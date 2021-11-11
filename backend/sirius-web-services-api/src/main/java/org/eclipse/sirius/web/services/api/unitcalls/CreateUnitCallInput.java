package org.eclipse.sirius.web.services.api.unitcalls;

import java.text.MessageFormat;
import java.util.UUID;

import org.eclipse.sirius.web.annotations.graphql.GraphQLField;
import org.eclipse.sirius.web.annotations.graphql.GraphQLID;
import org.eclipse.sirius.web.annotations.graphql.GraphQLInputObjectType;
import org.eclipse.sirius.web.annotations.graphql.GraphQLNonNull;
import org.eclipse.sirius.web.core.api.IInput;

/**
 * The input object for the create unit call mutation.
 */
@GraphQLInputObjectType
public final class CreateUnitCallInput implements IInput {
    private UUID id;

    private UUID editingContextId;

    private UUID rootObjectId;

    private ComputationUnitReleaseInput unitRelease;

    @Override
    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    public UUID getId() {
        return this.id;
    }

    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    public UUID getEditingContextId() {
        return this.editingContextId;
    }

    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    public UUID getRootObjectId() {
        return this.rootObjectId;
    }

    @GraphQLField
    @GraphQLNonNull
    public ComputationUnitReleaseInput getUnitRelease() {
        return this.unitRelease;
    }

    @Override
    public String toString() {
        String pattern = "{0}"; //$NON-NLS-1$
        return MessageFormat.format(pattern, this.getClass().getSimpleName());
    }
}
