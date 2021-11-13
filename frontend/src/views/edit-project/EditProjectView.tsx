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
} from "views/edit-project/EditProjectViewMachine";
import { Representation, Workbench } from "@eclipse-sirius/sirius-components";
import { NavigationBar } from "navigationBar/NavigationBar";

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

const useEditProjectViewStyles = makeStyles((theme) => ({
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

  useEffect(() => {
    const toolboxUrl = `${process.env.REACT_APP_BALTICLSC_API_URL}/backend/dev/toolbox/`;
    fetch(toolboxUrl, {
      headers: {
        authorization:
          "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImRlbW8iLCJzdWIiOiJkZW1vIiwianRpIjoiYjQ5ZTJjZmQ0ZGQ5NDM1ODk1OTEwNmY0ZjcwNWY0YTciLCJzaWQiOiJiYjdhNTNhMjA1ZDM0NWY4YmNlYWRhYWEwZjkxZjhiNyIsImV4cCI6MTYzNjQwMzA3MywiaXNzIjoid3V0LmJhbHRpY2xzYy5ldSIsImF1ZCI6Ind1dC5iYWx0aWNsc2MuZXUifQ.RXUVe-i4_6TFdtbp1SYCB0yPowcX75bT59cd_ddrGt0",
      },
    })
      .then((r) => r.json())
      .then((response) => {
        console.log("Got toolbox", response);
      });
  }, []);

  let main = null;
  if (editProjectView === "loaded" && project) {
    const onRepresentationSelected = (
      representationSelected: Representation
    ) => {
      const selectRepresentationEvent: SelectRepresentationEvent = {
        type: "SELECT_REPRESENTATION",
        representation: representationSelected,
      };
      dispatch(selectRepresentationEvent);
    };

    main = (
      <Workbench
        editingContextId={project.currentEditingContext.id}
        initialRepresentationSelected={representation}
        onRepresentationSelected={onRepresentationSelected}
        readOnly={false}
      />
    );
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
