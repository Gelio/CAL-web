package org.eclipse.sirius.web.services.api.unitcalls;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

import org.eclipse.sirius.web.annotations.graphql.GraphQLField;
import org.eclipse.sirius.web.annotations.graphql.GraphQLID;
import org.eclipse.sirius.web.annotations.graphql.GraphQLInputObjectType;
import org.eclipse.sirius.web.annotations.graphql.GraphQLNonNull;

@GraphQLInputObjectType
public class ComputationUnitRelease {
    private UUID id;

    private String name;

    private String version;

    private List<DeclaredDataPin> pins;

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
    public String getVersion() {
        return this.version;
    }

    @GraphQLField
    @GraphQLNonNull
    public List<DeclaredDataPin> getPins() {
        return pins;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}, name: {2}, version: {3}'}'"; //$NON-NLS-1$
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.id, this.name, this.version);
    }
}
