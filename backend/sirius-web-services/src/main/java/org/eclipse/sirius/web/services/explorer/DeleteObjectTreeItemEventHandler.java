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
package org.eclipse.sirius.web.services.explorer;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.sirius.web.core.api.IEditService;
import org.eclipse.sirius.web.core.api.IEditingContext;
import org.eclipse.sirius.web.core.api.IObjectService;
import org.eclipse.sirius.web.representations.Failure;
import org.eclipse.sirius.web.representations.IStatus;
import org.eclipse.sirius.web.representations.Success;
import org.eclipse.sirius.web.services.explorer.api.IDeleteTreeItemHandler;
import org.eclipse.sirius.web.spring.collaborative.api.ChangeKind;
import org.eclipse.sirius.web.trees.TreeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Handles semantic object deletion triggered via a tree item from the explorer.
 *
 * @author pcdavid
 */
@Service
public class DeleteObjectTreeItemEventHandler implements IDeleteTreeItemHandler {

    private final Logger logger = LoggerFactory.getLogger(DeleteObjectTreeItemEventHandler.class);

    private final IObjectService objectService;

    private final IEditService editService;

    public DeleteObjectTreeItemEventHandler(IObjectService objectService, IEditService editService) {
        this.objectService = Objects.requireNonNull(objectService);
        this.editService = Objects.requireNonNull(editService);
    }

    @Override
    public boolean canHandle(IEditingContext editingContext, TreeItem treeItem) {
        return treeItem.getKind().contains("::"); //$NON-NLS-1$
    }

    @Override
    public IStatus handle(IEditingContext editingContext, TreeItem treeItem) {
        Optional<Object> optionalObject = this.objectService.getObject(editingContext, treeItem.getId());
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            this.editService.delete(object);

            return new Success(ChangeKind.SEMANTIC_CHANGE, Map.of());
        } else {
            this.logger.warn("The object with the id {} does not exist", treeItem.getId()); //$NON-NLS-1$
        }
        return new Failure(""); //$NON-NLS-1$
    }
}
