import {
  Representation,
  RepresentationComponentProps,
  RepresentationContext,
  Selection,
  TreeItemContextMenuContext,
  TreeItemContextMenuContribution,
} from "@eclipse-sirius/sirius-components";
import { makeStyles, Snackbar } from "@material-ui/core";
import IconButton from "@material-ui/core/IconButton";
import CloseIcon from "@material-ui/icons/Close";
import { useMachine } from "@xstate/react";
import * as O from "fp-ts/lib/Option";
import { useAuthErrorStore } from "../../../auth/error";
import React, {
  PropsWithChildren,
  ReactElement,
  useContext,
  useEffect,
  useState,
} from "react";
import { LeftSite } from "./LeftSite";
import { HORIZONTAL, Panels, SECOND_PANEL } from "./Panels";
import { RightSite } from "./RightSite";
import { Toolbox } from "./Toolbox";
import {
  UpdateSelectionEvent,
  WorkbenchContext,
  WorkbenchEvent,
  workbenchMachine,
} from "./WorkbenchMachine";
import { pipe } from "fp-ts/lib/function";

export interface WorkbenchProps {
  editingContextId: string;
  representation?: Representation;
}

const useWorkbenchStyles = makeStyles(() => ({
  main: {
    display: "grid",
    gridTemplateRows: "minmax(0, 1fr)",
    gridTemplateColumns: "1fr",
  },
  representationArea: {
    display: "grid",
    gridTemplateColumns: "1fr",
    gridTemplateRows: "min-content 1fr",
  },
}));

/**
 * Altered sirius-components `Workbench`.
 *
 * The Workbench component does not allow customizing the displayed components
 * https://github.com/eclipse-sirius/sirius-components/issues/693
 * To be able to add new components, we need to have our own Workbench component.
 *
 * It is very similar to the original one.
 * @see https://github.com/eclipse-sirius/sirius-components/blob/master/frontend/src/workbench/Workbench.tsx
 *
 * See https://github.com/Gelio/CAL-web/issues/18#issuecomment-967889436 for more context on the customization.
 */
export const Workbench = ({
  editingContextId,
  representation,
  children,
}: PropsWithChildren<WorkbenchProps>) => {
  const classes = useWorkbenchStyles();
  const authError = useAuthErrorStore();
  const [authToastOpen, setAuthToastOpen] = useState(false);
  const { registry } = useContext(RepresentationContext);
  const [{ context }, dispatch] = useMachine<WorkbenchContext, WorkbenchEvent>(
    workbenchMachine,
    {
      context: {
        displayedRepresentation: representation,
      },
    }
  );
  const { selection, displayedRepresentation } = context;

  useEffect(() => {
    if (O.isSome(authError.error)) {
      setAuthToastOpen(true);
    }
  }, [authError.error]);

  const setSelection = (selection: Selection) => {
    const isRepresentation = registry.isRepresentation(selection.kind);
    const updateSelectionEvent: UpdateSelectionEvent = {
      type: "UPDATE_SELECTION",
      selection,
      isRepresentation,
    };
    dispatch(updateSelectionEvent);
  };

  const treeItemContextMenuContributions: ReactElement[] = [];
  React.Children.forEach(children, (child) => {
    if (
      React.isValidElement(child) &&
      child.type === TreeItemContextMenuContribution
    ) {
      treeItemContextMenuContributions.push(child);
    }
  });

  const leftSite = (
    <TreeItemContextMenuContext.Provider
      value={treeItemContextMenuContributions}
    >
      <LeftSite
        editingContextId={editingContextId}
        selection={selection}
        setSelection={setSelection}
        readOnly={false}
      />
    </TreeItemContextMenuContext.Provider>
  );

  const rightSite = (
    <RightSite
      editingContextId={editingContextId}
      selection={selection}
      setSelection={setSelection}
      readOnly={false}
    />
  );

  // NOTE: the original Workbench uses `OnboardArea` here, but that component is not exposed
  // @see https://github.com/eclipse-sirius/sirius-components/blob/ab8097c6c3593f10fdd16f9212762624a3639ccc/frontend/src/workbench/Workbench.tsx#L103-L110
  // @see https://github.com/eclipse-sirius/sirius-components/issues/830#issuecomment-967976773
  let main = <div>No representation found.</div>;
  if (displayedRepresentation) {
    const RepresentationComponent = registry.getComponent(
      displayedRepresentation
    );
    const props: RepresentationComponentProps = {
      editingContextId,
      representationId: displayedRepresentation.id,
      selection,
      setSelection,
      readOnly: false,
    };
    main = (
      <div
        className={classes.representationArea}
        data-testid="representation-area"
      >
        <Toolbox editingContextId={editingContextId} />
        <RepresentationComponent {...props} />
      </div>
    );
  }

  return (
    <>
      <Panels
        orientation={HORIZONTAL}
        firstPanel={leftSite}
        secondPanel={
          <div
            className={classes.main}
            data-testid="representationAndProperties"
          >
            <Panels
              orientation={HORIZONTAL}
              resizablePanel={SECOND_PANEL}
              firstPanel={main}
              secondPanel={rightSite}
              initialResizablePanelSize={300}
            />
          </div>
        }
        initialResizablePanelSize={350}
      />

      {/* NOTE: snackbar copied from sirius-components
      https://github.com/eclipse-sirius/sirius-components/blob/ab8097c6c3593f10fdd16f9212762624a3639ccc/frontend/src/representations/RepresentationsWebSocketContainer.tsx#L149-L168*/}
      <Snackbar
        anchorOrigin={{
          vertical: "bottom",
          horizontal: "left",
        }}
        open={authToastOpen}
        autoHideDuration={6000}
        onClose={() => setAuthToastOpen(false)}
        message={pipe(
          authError.error,
          O.map(
            (error) => `Authentication error: ${error.result.detailMessage}`
          ),
          O.getOrElse(() => "")
        )}
        action={
          <IconButton
            size="small"
            aria-label="close"
            color="inherit"
            onClick={() => setAuthToastOpen(false)}
          >
            <CloseIcon fontSize="small" />
          </IconButton>
        }
      />
    </>
  );
};
