import * as E from "fp-ts/lib/Either";
import { v4 as uuid } from "uuid";
import { gql, useMutation } from "@apollo/client";
import { getGQLComputationUnitReleaseInput, ToolboxEntry } from "./interop";
import { pipe } from "fp-ts/lib/function";
import { GQLCreateUnitCallInput } from "./types";
import {
  Button,
  CircularProgress,
  makeStyles,
  Tooltip,
} from "@material-ui/core";

interface UseToolboxEntryButtonProps {
  toolboxEntry: ToolboxEntry;
  editingContextId: string;
  rootObjectId: string;
}

const createUnitCallMutation = gql`
  mutation createUnitCall($input: CreateUnitCallInput!) {
    createUnitCall(input: $input) {
      __typename
      ... on CreateUnitCallSuccessPayload {
        id
        createdUnitCall {
          id
          kind
          label
        }
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`;

const useStyles = makeStyles((theme) => ({
  toolboxEntryIcon: {
    width: theme.spacing(4),
    height: theme.spacing(4),
  },
  toolboxEntryButton: {
    minWidth: theme.spacing(5),
  },
  loadingSpinner: {
    position: "absolute",
    top: 0,
    left: 4,
  },
}));

export const UseToolboxEntryButton = ({
  toolboxEntry,
  rootObjectId,
  editingContextId,
}: UseToolboxEntryButtonProps) => {
  const [createToolboxEntry, { loading }] = useMutation(createUnitCallMutation);
  const styles = useStyles();
  const nameAndVersion = `${toolboxEntry.unit.name} ${toolboxEntry.version}`;

  const createUnitCall = () => {
    pipe(
      getGQLComputationUnitReleaseInput(toolboxEntry),
      E.match(
        (errors) => {
          console.error("Cannot parse toolbox entry", errors);
        },
        (unitRelease) => {
          const input: GQLCreateUnitCallInput = {
            id: uuid(),
            rootObjectId,
            editingContextId,
            unitRelease,
          };
          createToolboxEntry({
            variables: { input },
          });
        }
      )
    );
  };

  return (
    <Button
      className={styles.toolboxEntryButton}
      onClick={createUnitCall}
      disabled={loading}
    >
      <Tooltip title={nameAndVersion}>
        <img
          src={toolboxEntry.unit.icon}
          alt={`Add call to "${nameAndVersion}"`}
          className={styles.toolboxEntryIcon}
        />
      </Tooltip>
      {loading && <CircularProgress className={styles.loadingSpinner} />}
    </Button>
  );
};
