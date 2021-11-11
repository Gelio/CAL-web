package org.eclipse.sirius.web.services.api.unitcalls;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.sirius.web.annotations.graphql.GraphQLField;
import org.eclipse.sirius.web.annotations.graphql.GraphQLID;
import org.eclipse.sirius.web.annotations.graphql.GraphQLNonNull;
import org.eclipse.sirius.web.annotations.graphql.GraphQLObjectType;
import org.eclipse.sirius.web.core.api.IPayload;

/**
 * The payload of the create unit call mutation.
 */
@GraphQLObjectType
public final class CreateUnitCallSuccessPayload implements IPayload {

    private final UUID id;

    private final Object createdUnitCall;

    public CreateUnitCallSuccessPayload(UUID id, Object createdUnitCall) {
        this.id = Objects.requireNonNull(id);
        this.createdUnitCall = Objects.requireNonNull(createdUnitCall);
    }

    @Override
    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    public UUID getId() {
        return this.id;
    }

    @GraphQLField
    @GraphQLNonNull
    public Object getCreatedUnitCall() {
        return this.createdUnitCall;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}'}'"; //$NON-NLS-1$
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.id);
    }
}
