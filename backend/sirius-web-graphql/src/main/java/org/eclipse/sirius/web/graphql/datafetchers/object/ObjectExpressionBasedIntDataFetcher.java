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
package org.eclipse.sirius.web.graphql.datafetchers.object;

import java.util.ArrayList;
import java.util.Map;
import java.util.OptionalInt;

import org.eclipse.sirius.web.annotations.spring.graphql.QueryDataFetcher;
import org.eclipse.sirius.web.graphql.schema.ObjectTypeProvider;
import org.eclipse.sirius.web.interpreter.AQLInterpreter;
import org.eclipse.sirius.web.interpreter.Result;
import org.eclipse.sirius.web.representations.VariableManager;
import org.eclipse.sirius.web.spring.graphql.api.IDataFetcherWithFieldCoordinates;

import graphql.schema.DataFetchingEnvironment;

/**
 * Computes the expression to get an Int.
 * <p>
 * It will be used to fetch the data for the following GraphQL field:
 * </p>
 *
 * <pre>
 * type Object {
 *   expressionBasedInt(expression: String!): Int
 * }
 * </pre>
 *
 * @author hmarchadour
 */
@QueryDataFetcher(type = ObjectTypeProvider.TYPE, field = ObjectTypeProvider.EXPRESSION_BASED_INT_FIELD)
public class ObjectExpressionBasedIntDataFetcher implements IDataFetcherWithFieldCoordinates<Integer> {

    @Override
    public Integer get(DataFetchingEnvironment environment) throws Exception {
        Object object = environment.getSource();
        String expression = environment.getArgument(ObjectTypeProvider.EXPRESSION_ARGUMENT);

        AQLInterpreter interpreter = new AQLInterpreter(new ArrayList<>(), new ArrayList<>());
        Result result = interpreter.evaluateExpression(Map.of(VariableManager.SELF, object), expression);
        OptionalInt optionalInt = result.asInt();
        if (optionalInt.isPresent()) {
            return Integer.valueOf(optionalInt.getAsInt());
        }
        return null;
    }

}
