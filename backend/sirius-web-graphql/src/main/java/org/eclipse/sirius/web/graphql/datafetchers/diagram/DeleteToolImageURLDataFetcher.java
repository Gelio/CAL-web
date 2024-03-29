/*******************************************************************************
 * Copyright (c) 2021 Obeo.
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
package org.eclipse.sirius.web.graphql.datafetchers.diagram;

import org.eclipse.sirius.web.annotations.spring.graphql.QueryDataFetcher;
import org.eclipse.sirius.web.diagrams.tools.ITool;
import org.eclipse.sirius.web.graphql.schema.DiagramTypesProvider;
import org.eclipse.sirius.web.graphql.schema.ImageURLFieldProvider;
import org.eclipse.sirius.web.spring.graphql.api.IDataFetcherWithFieldCoordinates;
import org.eclipse.sirius.web.spring.graphql.api.URLConstants;

import graphql.schema.DataFetchingEnvironment;

/**
 * The data fetcher used to concatenate the server image URL to the delete element tool image path.
 *
 * @author arichard
 */
@QueryDataFetcher(type = DiagramTypesProvider.DELETE_TOOL_TYPE, field = ImageURLFieldProvider.IMAGE_URL_FIELD)
public class DeleteToolImageURLDataFetcher implements IDataFetcherWithFieldCoordinates<String> {

    @Override
    public String get(DataFetchingEnvironment environment) throws Exception {
        ITool tool = environment.getSource();
        return URLConstants.IMAGE_BASE_PATH + tool.getImageURL();
    }
}
