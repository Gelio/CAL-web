import * as O from "fp-ts/lib/Option";
import * as E from "fp-ts/lib/Either";
import { ReactNode } from "react";
import { UseToolboxEntryButton } from "./UseToolboxEntryButton";
import { useRootObjectId } from "./root-object-id";
import { CircularProgress, styled, Typography } from "@material-ui/core";
import { useBalticLSCToolboxEntries } from "./use-balticlsc-toolbox-entries";

interface ToolboxProps {
  editingContextId: string;
  authToken: O.Option<string>;
  controls?: ReactNode;
}

export const Toolbox = ({
  editingContextId,
  controls,
  authToken,
}: ToolboxProps) => {
  const { error, loading, toolboxEntries } =
    useBalticLSCToolboxEntries(authToken);
  const rootObjectIdResOpt = useRootObjectId(editingContextId);

  return (
    <ToolboxContainer>
      {controls}

      {/* TODO: add a button to refresh the entries https://github.com/Gelio/CAL-web/issues/50 */}

      {O.isNone(rootObjectIdResOpt) || loading ? (
        <CircularProgress />
      ) : error || E.isLeft(rootObjectIdResOpt.value) ? (
        <>
          {error && (
            <Typography display="inline">
              Could not load toolbox: {error.message}
            </Typography>
          )}
          {E.isLeft(rootObjectIdResOpt.value) && (
            <Typography display="inline">
              {rootObjectIdResOpt.value.left.message}
            </Typography>
          )}
        </>
      ) : (
        // SAFETY: we checked that toolboxEntries does not have any error and is not loading
        toolboxEntries?.map((entry) => (
          <UseToolboxEntryButton
            toolboxEntry={entry}
            key={entry.uid}
            editingContextId={editingContextId}
            // SAFETY: we checked that the response is `Right`
            rootObjectId={(rootObjectIdResOpt.value as E.Right<string>).right}
          />
        ))
      )}
    </ToolboxContainer>
  );
};

const ToolboxContainer = styled("div")(({ theme }) => ({
  marginTop: theme.spacing(1),
  marginBottom: theme.spacing(1),
  paddingLeft: theme.spacing(1),
  paddingRight: theme.spacing(1),
  paddingBottom: theme.spacing(1),
  borderBottomColor: theme.palette.divider,
  borderBottomWidth: 1,
  borderBottomStyle: "solid",
  display: "flex",
  alignItems: "center",
  flexWrap: "wrap",
}));
