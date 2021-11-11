package org.eclipse.sirius.web.services.unitcalls;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.sirius.web.core.api.ErrorPayload;
import org.eclipse.sirius.web.core.api.IEditService;
import org.eclipse.sirius.web.core.api.IEditingContext;
import org.eclipse.sirius.web.core.api.IInput;
import org.eclipse.sirius.web.core.api.IObjectService;
import org.eclipse.sirius.web.core.api.IPayload;
import org.eclipse.sirius.web.services.api.unitcalls.CreateUnitCallInput;
import org.eclipse.sirius.web.spring.collaborative.api.ChangeDescription;
import org.eclipse.sirius.web.spring.collaborative.api.ChangeKind;
import org.eclipse.sirius.web.spring.collaborative.api.IEditingContextEventHandler;
import org.eclipse.sirius.web.spring.collaborative.api.Monitoring;
import org.eclipse.sirius.web.spring.collaborative.messages.ICollaborativeMessageService;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.CALFactory;
import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.DeclaredDataPin;
import eu.balticlsc.model.CAL.UnitCall;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;

/**
 * Handler used to create a new child.
 *
 * @author sbegaudeau
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
            var createChildInput = (CreateUnitCallInput) input;
            // NOTE: hardcode the representation ID for now
            var object = this.objectService.getObject(editingContext, createChildInput.getRootObjectId().toString());

            if (object.isPresent() && ComputationApplicationRelease.class.isInstance(object.get())) {
                var root = (ComputationApplicationRelease) object.get();
                // // @formatter:off
                var creationDescription = this.editService.getChildCreationDescriptions(editingContext.getId(), "CAL::ComputationApplicationRelease") //$NON-NLS-1$
                    .stream()
                    .filter(c -> c.getLabel().contains("Unit Release")) //$NON-NLS-1$
                    .findFirst();
                // @formatter:on
                creationDescription.flatMap(d -> this.editService.createChild(editingContext, root, d.getId())).map(ComputationUnitRelease.class::cast).ifPresent(x -> {
                    x.setName("Auto gen"); //$NON-NLS-1$
                    this.editService.getChildCreationDescriptions(editingContext.getId(), "CAL::ComputationUnitRelease") //$NON-NLS-1$
                            .stream().filter(c -> c.getLabel().contains("Declared Data Pin")) //$NON-NLS-1$
                            .findFirst().flatMap(d -> this.editService.createChild(editingContext, x, d.getId())).map(DeclaredDataPin.class::cast).ifPresent(pin -> {
                                pin.setName("Auto generated pin"); //$NON-NLS-1$
                            });

                });
                changeDescription = new ChangeDescription(ChangeKind.SEMANTIC_CHANGE, editingContext.getId(), input);
            }

            // Optional<Object> createdChildOptional = this.objectService.getObject(editingContext,
            // parentObjectId).flatMap(parent -> {
            // return this.editService.createChild(editingContext, parent, childCreationDescriptionId);
            // });
            //
            // if (createdChildOptional.isPresent()) {
            // payload = new CreateChildSuccessPayload(input.getId(), createdChildOptional.get());
            // changeDescription = new ChangeDescription(ChangeKind.SEMANTIC_CHANGE, editingContext.getId(), input);
            // } else {
            // message = this.messageService.objectCreationFailed();
            // }
        }

        if (payload == null) {
            payload = new ErrorPayload(input.getId(), message);
        }

        payloadSink.tryEmitValue(payload);
        changeDescriptionSink.tryEmitNext(changeDescription);
    }
}
