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
 *
 * @author gcoutable
 */
@GraphQLInputObjectType
public final class CreateUnitCallInput implements IInput {
    private UUID id;

    private String howToCallYou;

    @Override
    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    public UUID getId() {
        return this.id;
    }

    @GraphQLField
    @GraphQLNonNull
    public String getHowToCallYou() {
        return this.howToCallYou;
    }

    @Override
    public String toString() {
        String pattern = "{0}"; //$NON-NLS-1$
        return MessageFormat.format(pattern, this.getClass().getSimpleName());
    }
}
