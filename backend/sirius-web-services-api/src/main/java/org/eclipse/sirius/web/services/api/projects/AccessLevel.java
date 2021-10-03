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
package org.eclipse.sirius.web.services.api.projects;

import org.eclipse.sirius.web.annotations.graphql.GraphQLEnumType;

/**
 * The possible access levels to a project.
 *
 * @author pcdavid
 */
@GraphQLEnumType
public enum AccessLevel {
    READ, EDIT, ADMIN
}
