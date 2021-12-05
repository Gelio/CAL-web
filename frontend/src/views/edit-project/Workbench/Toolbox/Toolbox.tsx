import * as O from "fp-ts/lib/Option";
import * as E from "fp-ts/lib/Either";
import { UseToolboxEntryButton } from "./UseToolboxEntryButton";
import { useRootObjectId } from "./root-object-id";
import {
  CircularProgress,
  IconButton,
  styled,
  Tooltip,
  Typography,
} from "@material-ui/core";
import RefreshIcon from "@material-ui/icons/Refresh";
import { useBalticLSCToolboxEntries } from "./use-balticlsc-toolbox-entries";
import { TokenStore, useTokenStore } from "../../../../auth";

interface ToolboxProps {
  editingContextId: string;
}

const tokenSelector = ({ token }: TokenStore) => token;

export const Toolbox = ({ editingContextId }: ToolboxProps) => {
  const token = useTokenStore(tokenSelector);
  const { error, loading, toolboxEntries, refresh } =
    useBalticLSCToolboxEntries(token);
  const rootObjectIdResOpt = useRootObjectId(editingContextId);

  return (
    <ToolboxContainer>
      <RefreshToolboxButtonContainer>
        <RefreshToolboxButton disabled={loading} onClick={refresh} />
      </RefreshToolboxButtonContainer>

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

const RefreshToolboxButtonContainer = styled("div")(({ theme }) => ({
  marginRight: theme.spacing(1),
  borderRight: `solid 1px ${theme.palette.divider}`,
  borderBottom: `solid 1px ${theme.palette.divider}`,
  borderBottomRightRadius: 8,
}));
interface RefreshToolboxButtonProps {
  onClick: () => void;
  disabled: boolean;
}
const RefreshToolboxButton = ({
  onClick,
  disabled,
}: RefreshToolboxButtonProps) => {
  return (
    <Tooltip title="Refresh toolbox">
      <IconButton
        onClick={onClick}
        disabled={disabled}
        aria-label="Refresh toolbox"
      >
        <RefreshIcon />
      </IconButton>
    </Tooltip>
  );
};
