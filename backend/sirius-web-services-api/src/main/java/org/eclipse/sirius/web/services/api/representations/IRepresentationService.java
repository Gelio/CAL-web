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
package org.eclipse.sirius.web.services.api.representations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface to manipulate representations.
 *
 * @author gcoutable
 */
public interface IRepresentationService {

    boolean hasRepresentations(String objectId);

    Optional<RepresentationDescriptor> getRepresentationDescriptorForProjectId(String projectId, String representationId);

    List<RepresentationDescriptor> getRepresentationDescriptorsForProjectId(String projectId);

    List<RepresentationDescriptor> getRepresentationDescriptorsForObjectId(String objectId);

    Optional<RepresentationDescriptor> getRepresentation(UUID representationId);

    boolean existsById(UUID representationId);

    void delete(UUID representationId);

}
