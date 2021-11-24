/*******************************************************************************
 * Copyright (c) 2019, 2021 Obeo.
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
import { useQuery } from "@apollo/client";
import Grid from "@material-ui/core/Grid";
import IconButton from "@material-ui/core/IconButton";
import Snackbar from "@material-ui/core/Snackbar";
import { makeStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";
import CloseIcon from "@material-ui/icons/Close";
import { useMachine } from "@xstate/react";
import {
  Representation,
  Workbench as SiriusComponentsWorkbench,
} from "@eclipse-sirius/sirius-components";
import gql from "graphql-tag";
import { useEffect } from "react";
import {
  generatePath,
  useHistory,
  useParams,
  useRouteMatch,
} from "react-router-dom";
import { EditProjectNavbar } from "views/edit-project/EditProjectNavbar/EditProjectNavbar";
import {
  GQLGetProjectQueryData,
  GQLGetProjectQueryVariables,
  EditProjectViewParams,
} from "views/edit-project/EditProjectView.types";
import {
  EditProjectViewContext,
  EditProjectViewEvent,
  editProjectViewMachine,
  HandleFetchedProjectEvent,
  HideToastEvent,
  SchemaValue,
  SelectRepresentationEvent,
  ShowToastEvent,
} from "./EditProjectViewMachine";
import { Workbench } from "./Workbench";
import { NavigationBar } from "navigationBar/NavigationBar";
import { useBalticLSCAuthToken } from "./use-balticlsc-auth-token";
import { ToolboxAuthTokenControls } from "./Workbench/Toolbox";
import { flow } from "fp-ts/lib/function";
import * as O from "fp-ts/lib/Option";

const getProjectQuery = gql`
  query getRepresentation($projectId: ID!) {
    viewer {
      project(projectId: $projectId) {
        id
        name
        currentEditingContext {
          id
          representations {
            edges {
              node {
                id
                kind
                label
              }
            }
          }
        }
      }
    }
  }
`;

const useEditProjectViewStyles = makeStyles(() => ({
  editProjectView: {
    display: "grid",
    gridTemplateRows: "min-content minmax(0, 1fr)",
    gridTemplateColumns: "1fr",
    height: "100vh",
    width: "100vw",
  },
}));

export const EditProjectView = () => {
  const history = useHistory();
  const routeMatch = useRouteMatch();
  const { projectId, representationId } = useParams<EditProjectViewParams>();
  const classes = useEditProjectViewStyles();
  const [{ value, context }, dispatch] = useMachine<
    EditProjectViewContext,
    EditProjectViewEvent
  >(editProjectViewMachine);
  const { toast, editProjectView } = value as SchemaValue;
  const { project, representation, message } = context;

  const { loading, data, error } = useQuery<
    GQLGetProjectQueryData,
    GQLGetProjectQueryVariables
  >(getProjectQuery, {
    variables: {
      projectId,
    },
  });
  useEffect(() => {
    if (!loading) {
      if (error) {
        const showToastEvent: ShowToastEvent = {
          type: "SHOW_TOAST",
          message: "An unexpected error has occurred, please refresh the page",
        };
        dispatch(showToastEvent);
      }
      if (data) {
        const fetchProjectEvent: HandleFetchedProjectEvent = {
          type: "HANDLE_FETCHED_PROJECT",
          data,
        };
        dispatch(fetchProjectEvent);
      }
    }
  }, [loading, data, error, dispatch]);

  useEffect(() => {
    if (representation && representation.id !== representationId) {
      const pathname = generatePath(routeMatch.path, {
        projectId,
        representationId: representation.id,
      });
      history.push({ pathname });
    } else if (
      editProjectView === "loaded" &&
      representation === null &&
      representationId
    ) {
      const pathname = generatePath(routeMatch.path, {
        projectId,
        representationId: null,
      });
      history.push({ pathname });
    }
  }, [
    editProjectView,
    projectId,
    routeMatch,
    history,
    representation,
    representationId,
  ]);

  const balticLSCAuthToken = useBalticLSCAuthToken();

  let main = null;
  if (editProjectView === "loaded" && project) {
    if (representation) {
      main = (
        <Workbench
          editingContextId={project.currentEditingContext.id}
          representation={representation}
          balticLSCAuthToken={balticLSCAuthToken.authToken}
          toolboxControls={
            <ToolboxAuthTokenControls
              authToken={balticLSCAuthToken.authToken}
              onAuthTokenChange={flow(O.of, balticLSCAuthToken.setAuthToken)}
            />
          }
        />
      );
    } else {
      // NOTE: the user needs to create a model in the project and a representation for it
      // The `OnboardArea` component is not exposed in `sirius-components`
      // (https://github.com/eclipse-sirius/sirius-components/issues/830#issuecomment-967976773),
      // so we need to show the original `Workbench` component instead and
      // switch to our one after the user selects a representation.
      main = (
        <SiriusComponentsWorkbench
          editingContextId={project.currentEditingContext.id}
          onRepresentationSelected={(newRepresentation: Representation) => {
            const event: SelectRepresentationEvent = {
              type: "SELECT_REPRESENTATION",
              representation: newRepresentation,
            };

            dispatch(event);
          }}
          readOnly={false}
        />
      );
    }
  } else if (editProjectView === "missing") {
    main = (
      <Grid container justifyContent="center" alignItems="center">
        <Typography variant="h4" align="center" gutterBottom>
          The project does not exist
        </Typography>
      </Grid>
    );
  }

  let navbar = null;
  if (editProjectView === "missing" || editProjectView === "loading") {
    navbar = <NavigationBar />;
  } else if (editProjectView === "loaded") {
    navbar = <EditProjectNavbar project={project} />;
  }

  return (
    <>
      <div className={classes.editProjectView}>
        {navbar}
        {main}
      </div>
      <Snackbar
        anchorOrigin={{
          vertical: "bottom",
          horizontal: "right",
        }}
        open={toast === "visible"}
        autoHideDuration={3000}
        onClose={() => dispatch({ type: "HIDE_TOAST" } as HideToastEvent)}
        message={message}
        action={
          <IconButton
            size="small"
            aria-label="close"
            color="inherit"
            onClick={() => dispatch({ type: "HIDE_TOAST" } as HideToastEvent)}
          >
            <CloseIcon fontSize="small" />
          </IconButton>
        }
        data-testid="error"
      />
    </>
  );
};
