package org.eclipse.sirius.web.services.api.unitcalls;

import java.text.MessageFormat;
import java.util.UUID;

import org.eclipse.sirius.web.annotations.graphql.GraphQLField;
import org.eclipse.sirius.web.annotations.graphql.GraphQLID;
import org.eclipse.sirius.web.annotations.graphql.GraphQLInputObjectType;
import org.eclipse.sirius.web.annotations.graphql.GraphQLNonNull;

@GraphQLInputObjectType
public class DeclaredDataPin {
    private UUID id;

    private String name;

    private DataBinding binding;

    private Multiplicity tokenMultiplicity;

    private Multiplicity dataMultiplicity;

    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    public UUID getId() {
        return this.id;
    }

    @GraphQLField
    @GraphQLNonNull
    public String getName() {
        return this.name;
    }

    @GraphQLField
    @GraphQLNonNull
    public DataBinding getBinding() {
        return this.binding;
    }

    @GraphQLField
    @GraphQLNonNull
    public Multiplicity getTokenMultiplicity() {
        return this.tokenMultiplicity;
    }

    @GraphQLField
    @GraphQLNonNull
    public Multiplicity getDataMultiplicity() {
        return this.dataMultiplicity;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}, name: {2}, binding: {3}, tokenMultiplicity: {4}, dataMultiplicity: {5}'}'"; //$NON-NLS-1$
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.id, this.name, this.binding, this.tokenMultiplicity, this.dataMultiplicity);
    }
}
