import {
  Representation,
  RepresentationComponentProps,
  RepresentationContext,
  Selection,
} from "@eclipse-sirius/sirius-components";
import { makeStyles } from "@material-ui/core";
import { useMachine } from "@xstate/react";
import { useContext } from "react";
import { LeftSite } from "./LeftSite";
import { HORIZONTAL, Panels, SECOND_PANEL } from "./Panels";
import { RightSite } from "./RightSite";
import {
  UpdateSelectionEvent,
  WorkbenchContext,
  WorkbenchEvent,
  workbenchMachine,
} from "./WorkbenchMachine";

interface WorkbenchProps {
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
    gridTemplateRows: "1ft",
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
}: WorkbenchProps) => {
  const classes = useWorkbenchStyles();
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

  const setSelection = (selection: Selection) => {
    const isRepresentation = registry.isRepresentation(selection.kind);
    const updateSelectionEvent: UpdateSelectionEvent = {
      type: "UPDATE_SELECTION",
      selection,
      isRepresentation,
    };
    dispatch(updateSelectionEvent);
  };

  const leftSite = (
    <LeftSite
      editingContextId={editingContextId}
      selection={selection}
      setSelection={setSelection}
      // TODO: change to `true` after testing that everything works
      readOnly={false}
    />
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
        <RepresentationComponent {...props} />
      </div>
    );
  }

  return (
    <Panels
      orientation={HORIZONTAL}
      firstPanel={leftSite}
      secondPanel={
        <div className={classes.main} data-testid="representationAndProperties">
          <Panels
            orientation={HORIZONTAL}
            resizablePanel={SECOND_PANEL}
            firstPanel={main}
            secondPanel={rightSite}
            initialResizablePanelSize={300}
          />
        </div>
      }
      initialResizablePanelSize={300}
    />
  );
};
