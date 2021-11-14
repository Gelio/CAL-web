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
import {
  GQLGetProjectQueryData,
  Project,
} from "views/edit-project/EditProjectView.types";
import { Representation } from "@eclipse-sirius/sirius-components";
import { assign, Machine, send } from "xstate";
import { pure } from "xstate/lib/actions";

export interface EditProjectViewStateSchema {
  states: {
    toast: {
      states: {
        visible: {};
        hidden: {};
      };
    };
    editProjectView: {
      states: {
        loading: {};
        loaded: {};
        missing: {};
      };
    };
  };
}

export type SchemaValue = {
  toast: "visible" | "hidden";
  editProjectView: "loading" | "loaded" | "missing";
};

export interface EditProjectViewContext {
  project: Project | null;
  representation: Representation | null;
  message: string | null;
}

export type ShowToastEvent = { type: "SHOW_TOAST"; message: string };
export type HideToastEvent = { type: "HIDE_TOAST" };
export type HandleFetchedProjectEvent = {
  type: "HANDLE_FETCHED_PROJECT";
  data: GQLGetProjectQueryData;
};
export type SelectRepresentationEvent = {
  type: "SELECT_REPRESENTATION";
  representation: Representation;
};
export type EditProjectViewEvent =
  | HandleFetchedProjectEvent
  | SelectRepresentationEvent
  | ShowToastEvent
  | HideToastEvent;

export const editProjectViewMachine = Machine<
  EditProjectViewContext,
  EditProjectViewStateSchema,
  EditProjectViewEvent
>(
  {
    type: "parallel",
    context: {
      project: null,
      representation: null,
      message: null,
    },
    states: {
      toast: {
        initial: "hidden",
        states: {
          hidden: {
            on: {
              SHOW_TOAST: {
                target: "visible",
                actions: "setMessage",
              },
            },
          },
          visible: {
            on: {
              HIDE_TOAST: {
                target: "hidden",
                actions: "clearMessage",
              },
            },
          },
        },
      },
      editProjectView: {
        initial: "loading",
        states: {
          loading: {
            on: {
              HANDLE_FETCHED_PROJECT: [
                {
                  cond: "isMissing",
                  target: "missing",
                },
                {
                  target: "loaded",
                  actions: "updateProject",
                },
              ],
            },
          },
          loaded: {
            type: "final",
            on: {
              SELECT_REPRESENTATION: {
                target: "loaded",
                actions: "selectRepresentation",
              },
            },
          },
          missing: {
            type: "final",
          },
        },
      },
    },
  },
  {
    guards: {
      isMissing: (_, event) => {
        const { data } = event as HandleFetchedProjectEvent;
        return !data.viewer.project;
      },
    },
    actions: {
      updateProject: pure((_, event) => {
        const { data } = event as HandleFetchedProjectEvent;
        const { project: gQLProject } = data.viewer;
        const { id, name, currentEditingContext } = gQLProject;
        const project: Project = {
          id,
          name,
          currentEditingContext: { id: currentEditingContext.id },
        };

        const contextUpdate: Partial<EditProjectViewContext> = {
          project,
        };

        const representations =
          gQLProject.currentEditingContext.representations.edges.map(
            ({ node }) => node
          );
        let message: string | undefined;
        if (representations.length === 0) {
          message = [
            "No representations found in the project.",
            "A pre-created representation is required to work on the model.",
          ].join(" ");
        } else if (representations.length === 1) {
          contextUpdate.representation = { ...representations[0] };
        } else {
          message = [
            `${representations.length} representations found, but expected only 1 representation.`,
            "Remove redundant representations and try again.",
          ].join(" ");
        }
        const showToastEvent: ShowToastEvent | undefined = message && {
          type: "SHOW_TOAST",
          message,
        };

        const actions = [
          assign(contextUpdate),
          showToastEvent && send(showToastEvent),
        ].filter(Boolean);
        return actions;
      }),
      selectRepresentation: assign((_, event) => {
        const { representation } = event as SelectRepresentationEvent;
        return { representation };
      }),
      setMessage: assign((_, event) => {
        const { message } = event as ShowToastEvent;
        return { message };
      }),
      clearMessage: assign((_) => {
        return { message: null };
      }),
    },
  }
);
