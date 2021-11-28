/*******************************************************************************
 * Copyright (c) 2019, 2020 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.web.sample.services;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.sirius.web.persistence.repositories.IProjectRepository;
import org.eclipse.sirius.web.services.api.projects.AccessLevel;
import org.eclipse.sirius.web.services.api.projects.IProjectAccessPolicy;
import org.springframework.stereotype.Service;

/**
 * The access policy of Sirius Web.
 *
 * @author sbegaudeau
 */
@Service
public class ProjectAccessPolicy implements IProjectAccessPolicy {

    private final IProjectRepository projectRepository;

    public ProjectAccessPolicy(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<AccessLevel> getAccessLevel(String username, UUID projectId) {
        if (this.ownsProject(username, projectId)) {
            return Optional.of(AccessLevel.ADMIN);
        }

        return Optional.empty();
    }

    @Override
    public boolean canEdit(String username, UUID projectId) {
        return this.ownsProject(username, projectId);
    }

    @Override
    public boolean canAdmin(String username, UUID projectId) {
        return this.ownsProject(username, projectId);
    }

    private Boolean ownsProject(String username, UUID projectId) {
        // @formatter:off
        return projectRepository.findById(projectId)
            .map(project ->
                Objects.equals(project.getOwner().getUsername(), username)
            )
            .orElse(false);
        // @formatter:on
    }
}
