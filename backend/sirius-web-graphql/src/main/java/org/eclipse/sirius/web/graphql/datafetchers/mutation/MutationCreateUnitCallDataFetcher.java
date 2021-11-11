package org.eclipse.sirius.web.graphql.datafetchers.mutation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.eclipse.sirius.web.annotations.graphql.GraphQLMutationTypes;
import org.eclipse.sirius.web.annotations.spring.graphql.MutationDataFetcher;
import org.eclipse.sirius.web.core.api.ErrorPayload;
import org.eclipse.sirius.web.core.api.IPayload;
import org.eclipse.sirius.web.graphql.messages.IGraphQLMessageService;
import org.eclipse.sirius.web.graphql.schema.MutationTypeProvider;
import org.eclipse.sirius.web.services.api.unitcalls.CreateUnitCallInput;
import org.eclipse.sirius.web.services.api.unitcalls.CreateUnitCallSuccessPayload;
import org.eclipse.sirius.web.spring.collaborative.api.IEditingContextEventProcessorRegistry;
import org.eclipse.sirius.web.spring.graphql.api.IDataFetcherWithFieldCoordinates;

import graphql.schema.DataFetchingEnvironment;

/**
 * The data fetcher used to create a UnitCall based on a BalticLSC toolbox entry.
 * <p>
 * It will be used to handle the following GraphQL field:
 * </p>
 *
 * <pre>
 * type Mutation {
 *   createUnitCall(input: CreateUnitCallInput!): CreateUnitCallPayload!
 * }
 * </pre>
 */
// @formatter:off
@GraphQLMutationTypes(
    input = CreateUnitCallInput.class,
    payloads = {
        CreateUnitCallSuccessPayload.class
    }
)
@MutationDataFetcher(type = MutationTypeProvider.TYPE, field = MutationCreateUnitCallDataFetcher.CREATE_UNIT_CALL_FIELD)
// @formatter:on
public class MutationCreateUnitCallDataFetcher implements IDataFetcherWithFieldCoordinates<CompletableFuture<IPayload>> {

    public static final String CREATE_UNIT_CALL_FIELD = "createUnitCall"; //$NON-NLS-1$

    private final ObjectMapper objectMapper;

    private final IEditingContextEventProcessorRegistry editingContextEventProcessorRegistry;

    private final IGraphQLMessageService messageService;

    public MutationCreateUnitCallDataFetcher(ObjectMapper objectMapper, IEditingContextEventProcessorRegistry editingContextEventProcessorRegistry, IGraphQLMessageService messageService) {
        this.objectMapper = Objects.requireNonNull(objectMapper);
        this.editingContextEventProcessorRegistry = Objects.requireNonNull(editingContextEventProcessorRegistry);
        this.messageService = Objects.requireNonNull(messageService);
    }

    @Override
    public CompletableFuture<IPayload> get(DataFetchingEnvironment environment) throws Exception {
        Object argument = environment.getArgument(MutationTypeProvider.INPUT_ARGUMENT);
        var input = this.objectMapper.convertValue(argument, CreateUnitCallInput.class);

        // @formatter:off
        return this.editingContextEventProcessorRegistry.dispatchEvent(input.getEditingContextId(), input)
                .defaultIfEmpty(new ErrorPayload(input.getId(), this.messageService.unexpectedError()))
                .toFuture();
        // @formatter:on
    }

}
