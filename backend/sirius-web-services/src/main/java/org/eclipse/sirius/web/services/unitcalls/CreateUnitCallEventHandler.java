package org.eclipse.sirius.web.services.unitcalls;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.sirius.web.core.api.ChildCreationDescription;
import org.eclipse.sirius.web.core.api.ErrorPayload;
import org.eclipse.sirius.web.core.api.IEditService;
import org.eclipse.sirius.web.core.api.IEditingContext;
import org.eclipse.sirius.web.core.api.IInput;
import org.eclipse.sirius.web.core.api.IObjectService;
import org.eclipse.sirius.web.core.api.IPayload;
import org.eclipse.sirius.web.services.api.unitcalls.ComputationUnitReleaseInput;
import org.eclipse.sirius.web.services.api.unitcalls.CreateUnitCallInput;
import org.eclipse.sirius.web.services.api.unitcalls.CreateUnitCallSuccessPayload;
import org.eclipse.sirius.web.services.api.unitcalls.DeclaredDataPinInput;
import org.eclipse.sirius.web.spring.collaborative.api.ChangeDescription;
import org.eclipse.sirius.web.spring.collaborative.api.ChangeKind;
import org.eclipse.sirius.web.spring.collaborative.api.IEditingContextEventHandler;
import org.eclipse.sirius.web.spring.collaborative.api.Monitoring;
import org.eclipse.sirius.web.spring.collaborative.messages.ICollaborativeMessageService;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.DeclaredDataPin;
import eu.balticlsc.model.CAL.UnitCall;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;

/**
 * Handler used to create a new unit call.
 */
@Service
public class CreateUnitCallEventHandler implements IEditingContextEventHandler {

    private final IObjectService objectService;

    private final IEditService editService;

    private final ICollaborativeMessageService messageService;

    private final Counter counter;

    public CreateUnitCallEventHandler(IObjectService objectService, IEditService editService, ICollaborativeMessageService messageService, MeterRegistry meterRegistry) {
        this.objectService = Objects.requireNonNull(objectService);
        this.editService = Objects.requireNonNull(editService);
        this.messageService = Objects.requireNonNull(messageService);

        // @formatter:off
        this.counter = Counter.builder(Monitoring.EVENT_HANDLER)
                .tag(Monitoring.NAME, this.getClass().getSimpleName())
                .register(meterRegistry);
        // @formatter:on
    }

    @Override
    public boolean canHandle(IEditingContext editingContext, IInput input) {
        return input instanceof CreateUnitCallInput;
    }

    @Override
    public void handle(One<IPayload> payloadSink, Many<ChangeDescription> changeDescriptionSink, IEditingContext editingContext, IInput input) {
        this.counter.increment();

        String message = this.messageService.invalidInput(input.getClass().getSimpleName(), CreateUnitCallInput.class.getSimpleName());
        ChangeDescription changeDescription = new ChangeDescription(ChangeKind.NOTHING, editingContext.getId(), input);
        IPayload payload = null;

        if (input instanceof CreateUnitCallInput) {
            var createUnitCallInput = (CreateUnitCallInput) input;
            var rootObject = this.objectService.getObject(editingContext, createUnitCallInput.getRootObjectId().toString());

            // @formatter:off
            var computationApplicationRelease = rootObject
                .filter(ComputationApplicationRelease.class::isInstance)
                .map(ComputationApplicationRelease.class::cast);
            // @formatter:on

            var unitCall = computationApplicationRelease.map(applicationRelease -> {
                var unitRelease = this.getOrCreateComputationUnitRelease(applicationRelease, createUnitCallInput.getUnitRelease(), changeDescriptionSink, editingContext);
                return this.createUnitCall(applicationRelease, unitRelease, changeDescriptionSink, editingContext);
            });

            changeDescription = new ChangeDescription(ChangeKind.SEMANTIC_CHANGE, editingContext.getId(), input);

            if (unitCall.isPresent()) {
                payload = new CreateUnitCallSuccessPayload(input.getId(), unitCall.get());
                changeDescription = new ChangeDescription(ChangeKind.SEMANTIC_CHANGE, editingContext.getId(), input);
            } else {
                message = this.messageService.objectCreationFailed();
            }
        }

        if (payload == null) {
            payload = new ErrorPayload(input.getId(), message);
        }

        payloadSink.tryEmitValue(payload);
        changeDescriptionSink.tryEmitNext(changeDescription);
    }

    private ComputationUnitRelease getOrCreateComputationUnitRelease(ComputationApplicationRelease computationApplicationRelease, ComputationUnitReleaseInput unitReleaseInput,
            Many<ChangeDescription> changeDescriptionSink, IEditingContext editingContext) {
        // @formatter:off
        return computationApplicationRelease.getUnits().stream()
            .filter(unitRelease -> {
                return Objects.equals(unitRelease.getName(), unitReleaseInput.getName()) &&
                    Objects.equals(unitRelease.getVersion(), unitReleaseInput.getVersion());
            })
            .findFirst()
            .orElseGet(() -> {
                return this.createComputationUnitRelease(computationApplicationRelease, unitReleaseInput, changeDescriptionSink, editingContext);
            });
        // @formatter:on
    }

    private ComputationUnitRelease createComputationUnitRelease(ComputationApplicationRelease computationApplicationRelease, ComputationUnitReleaseInput unitReleaseInput,
            Many<ChangeDescription> changeDescriptionSink, IEditingContext editingContext) {
        // NOTE: changeDescriptionSink is not used ATM. It could be necessary to fix
        // https://github.com/Gelio/CAL-web/issues/39
        var unitRelease = this.editService.createChild(editingContext, computationApplicationRelease, this.getUnitReleaseCreationDescriptionId(editingContext.getId()))
                .map(ComputationUnitRelease.class::cast).orElseThrow();

        unitRelease.setName(unitReleaseInput.getName());
        unitRelease.setVersion(unitReleaseInput.getVersion());
        // TODO: handlle unitReleaseInput.getId()

        unitReleaseInput.getPins().forEach(pin -> this.createDeclaredDataPin(unitRelease, pin, changeDescriptionSink, editingContext));

        return unitRelease;
    }

    private DeclaredDataPin createDeclaredDataPin(ComputationUnitRelease computationUnitRelease, DeclaredDataPinInput declaredDataPinInput, Many<ChangeDescription> changeDescriptionSink,
            IEditingContext editingContext) {
        // NOTE: changeDescriptionSink is not used ATM. It could be necessary to fix
        // https://github.com/Gelio/CAL-web/issues/39
        var declaredDataPin = this.editService.createChild(editingContext, computationUnitRelease, this.getDeclaredDataPinCreationDescriptionId(editingContext.getId()))
                .map(DeclaredDataPin.class::cast).orElseThrow();
        declaredDataPin.setName(declaredDataPinInput.getName());

        // declaredDataPin.setBinding(declaredDataPinInput.getBinding());
        // declaredDataPin.setDataMultiplicity(declaredDataPinInput.getDataMultiplicity());
        // declaredDataPin.setTokenMultiplicity(declaredDataPinInput.getTokenMultiplicity());

        return declaredDataPin;
    }

    private UnitCall createUnitCall(ComputationApplicationRelease computationApplicationRelease, ComputationUnitRelease unitRelease, Many<ChangeDescription> changeDescriptionSink,
            IEditingContext editingContext) {
        // NOTE: changeDescriptionSink is not used ATM. It could be necessary to fix
        // https://github.com/Gelio/CAL-web/issues/39
        var unitCall = this.editService.createChild(editingContext, computationApplicationRelease, this.getUnitCallCreationDescriptionId(editingContext.getId())).map(UnitCall.class::cast)
                .orElseThrow();

        unitCall.setName(unitRelease.getName() + " call"); //$NON-NLS-1$
        unitCall.setUnit(unitRelease);

        return unitCall;
    }

    private String getUnitReleaseCreationDescriptionId(UUID editingContextId) {
        return this.getChildCreationDescriptionId(editingContextId, "CAL::ComputationApplicationRelease", "Unit Release"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private String getDeclaredDataPinCreationDescriptionId(UUID editingContextId) {
        return this.getChildCreationDescriptionId(editingContextId, "CAL::ComputationUnitRelease", "Declared Data Pin"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private String getUnitCallCreationDescriptionId(UUID editingContextId) {
        return this.getChildCreationDescriptionId(editingContextId, "CAL::ComputationApplicationRelease", "Unit Call"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private String getChildCreationDescriptionId(UUID editingContextId, String parentClassId, String childLabel) {
        return this.editService.getChildCreationDescriptions(editingContextId, parentClassId).stream().filter(c -> c.getLabel().contains(childLabel)).findFirst()
                // NOTE: if the description cannot be found, it's a bug
                .map(ChildCreationDescription::getLabel).orElseThrow();
    }
}
