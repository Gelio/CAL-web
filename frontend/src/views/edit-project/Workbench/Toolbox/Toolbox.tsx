import * as O from "fp-ts/lib/Option";
import * as E from "fp-ts/lib/Either";
import { flow } from "fp-ts/lib/function";
import IconError from "@material-ui/icons/Error";
import { PropsWithChildren, useMemo, useState } from "react";
import { UseToolboxEntryButton } from "./UseToolboxEntryButton";
import { useRootObjectId } from "./root-object-id";
import {
  Box,
  CircularProgress,
  Paper,
  styled,
  Tooltip,
  Typography,
} from "@material-ui/core";
import { ChangeAuthenticationTokenButton } from "./ChangeAuthenticationTokenButton";
import {
  getTokenVerificationErrorTitle,
  isTokenExpiredPipeline,
} from "./is-token-expired";
import { useBalticLSCToolboxEntries } from "./use-balticlsc-toolbox-entries";

interface ToolboxProps {
  editingContextId: string;
}

export const Toolbox = ({ editingContextId }: ToolboxProps) => {
  const [authToken, setAuthToken] = useState<O.Option<string>>(O.none);

  const tokenExpiredResult = useMemo(
    () => O.map(isTokenExpiredPipeline)(authToken),
    [authToken]
  );

  const { error, loading, toolboxEntries } =
    useBalticLSCToolboxEntries(authToken);
  const rootObjectIdResOpt = useRootObjectId(editingContextId);

  return (
    <ToolboxContainer>
      <ToolboxControls elevation={1}>
        <ChangeAuthenticationTokenButton
          authenticationToken={authToken}
          onAuthenticationTokenChange={flow(O.some, setAuthToken)}
        />
        {O.isSome(tokenExpiredResult) ? (
          E.isLeft(tokenExpiredResult.value) ? (
            <Box marginRight={1} display="flex" alignItems="center">
              <ErrorTooltip>
                {getTokenVerificationErrorTitle(tokenExpiredResult.value.left)}
              </ErrorTooltip>
            </Box>
          ) : (
            tokenExpiredResult.value.right && (
              <Box marginRight={1} display="flex" alignItems="center">
                <ErrorTooltip>Token expired</ErrorTooltip>
              </Box>
            )
          )
        ) : (
          O.isNone(authToken) && (
            <Box marginRight={1} display="flex" alignItems="center">
              <ErrorTooltip>Missing authentiation token</ErrorTooltip>
            </Box>
          )
        )}
      </ToolboxControls>

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

const ToolboxControls = styled(Paper)(({ theme }) => ({
  display: "inline-flex",
  alignItems: "center",
  marginRight: theme.spacing(1),
  marginBottom: theme.spacing(1),
}));

const ErrorTooltip = ({ children }: PropsWithChildren<{}>) => {
  return (
    <Tooltip title={<Typography variant="body2">{children}</Typography>}>
      <IconError color="error" />
    </Tooltip>
  );
};
