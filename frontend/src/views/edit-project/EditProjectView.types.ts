/*******************************************************************************
 * Copyright (c) 2021 Obeo and others.
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

export type EditingContext = {
  id: string;
};

export type Project = {
  id: string;
  name: string;
  currentEditingContext: EditingContext;
};

export type GQLRepresentation = {
  id: string;
  label: string;
  kind: string;
};

export interface GQLConnection<T> {
  edges: { node: T }[];
}

export type GQLEditingContext = {
  id: string;
  representations: GQLConnection<GQLRepresentation>;
};

export type GQLProject = {
  id: string;
  name: string;
  currentEditingContext: GQLEditingContext;
};

export type GQLViewer = {
  project: GQLProject;
};

export type GQLGetProjectQueryData = {
  viewer: GQLViewer;
};

export type GQLGetProjectQueryVariables = {
  projectId: string;
};

export interface EditProjectViewParams {
  projectId: string;
  representationId: string;
}
