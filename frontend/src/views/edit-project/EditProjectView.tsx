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
import AddIcon from "@material-ui/icons/Add";
import GetAppIcon from "@material-ui/icons/GetApp";
import { useMachine } from "@xstate/react";
import {
  httpOrigin,
  NewObjectModal,
  NewRepresentationModal,
  NewRootObjectModal,
  Representation,
  TreeItemHandler,
  TreeItemHandlersContext,
  Workbench as SiriusComponentsWorkbench,
} from "@eclipse-sirius/sirius-components";
import gql from "graphql-tag";
import { useContext, useEffect } from "react";
import {
  generatePath,
  useHistory,
  useParams,
  useRouteMatch,
} from "react-router-dom";
import { EditProjectNavbar } from "./EditProjectNavbar/EditProjectNavbar";
import {
  GQLGetProjectQueryData,
  GQLGetProjectQueryVariables,
  EditProjectViewParams,
} from "./EditProjectView.types";
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
import { NavigationBar } from "../../navigationBar/NavigationBar";
import { ListItemIcon, ListItemText, MenuItem } from "@material-ui/core";

export const getProjectQuery = gql`
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

const documentItemHandler: TreeItemHandler = {
  handles: (treeItem) => treeItem.kind === "Model",
  getModal: (name) => {
    if (name === "CreateNewRootObject") {
      return NewRootObjectModal;
    }
  },
  getMenuEntries: (
    item,
    editingContextId,
    readOnly,
    openModal,
    closeContextMenu,
    classes
  ) => {
    return [
      <MenuItem
        key="new-object"
        data-testid="new-object"
        onClick={() => openModal("CreateNewRootObject")}
        dense
        className={classes.item}
      >
        <ListItemIcon>
          <AddIcon fontSize="small" />
        </ListItemIcon>
        <ListItemText primary="New object" />
      </MenuItem>,
      <MenuItem
        key="download"
        divider
        onClick={closeContextMenu}
        component="a"
        href={`${httpOrigin}/api/editingcontexts/${editingContextId}/documents/${item.id}`}
        type="application/octet-stream"
        data-testid="download"
        disabled={readOnly}
        dense
        className={classes.item}
      >
        <ListItemIcon>
          <GetAppIcon fontSize="small" />
        </ListItemIcon>
        <ListItemText primary="Download" />
      </MenuItem>,
    ];
  },
};

const semanticObjectItemHandler: TreeItemHandler = {
  handles: (treeItem) => treeItem.kind !== null && treeItem.kind.includes("::"),
  getModal: (name) => {
    if (name === "CreateNewObject") {
      return NewObjectModal;
    } else if (name === "CreateRepresentation") {
      return NewRepresentationModal;
    }
  },
  getMenuEntries: (
    item,
    editingContextId,
    readOnly,
    openModal,
    closeContextMenu,
    classes
  ) => {
    return [
      <MenuItem
        key="new-object"
        onClick={() => openModal("CreateNewObject")}
        data-testid="new-object"
        dense
        disabled={readOnly}
        className={classes.item}
      >
        <ListItemIcon>
          <AddIcon fontSize="small" />
        </ListItemIcon>
        <ListItemText primary="New object" />
      </MenuItem>,
      <MenuItem
        key="new-representation"
        onClick={() => openModal("CreateRepresentation")}
        data-testid="new-representation"
        dense
        disabled={readOnly}
        className={classes.item}
      >
        <ListItemIcon>
          <AddIcon fontSize="small" />
        </ListItemIcon>
        <ListItemText primary="New representation" />
      </MenuItem>,
    ];
  },
};

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

  const { registerTreeItemHandler } = useContext(TreeItemHandlersContext);
  registerTreeItemHandler(documentItemHandler);
  registerTreeItemHandler(semanticObjectItemHandler);

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

  let main = null;
  if (editProjectView === "loaded" && project) {
    if (representation) {
      main = (
        <Workbench
          editingContextId={project.currentEditingContext.id}
          representation={representation}
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
