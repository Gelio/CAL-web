import * as O from "fp-ts/lib/Option";
import * as E from "fp-ts/lib/Either";
import { Box, Paper, styled, Tooltip, Typography } from "@material-ui/core";
import IconError from "@material-ui/icons/Error";
import { PropsWithChildren, useMemo } from "react";
import {
  getTokenVerificationErrorTitle,
  isTokenExpiredPipeline,
} from "./is-token-expired";
import { ChangeAuthenticationTokenButton } from "./ChangeAuthenticationTokenButton";

interface ToolboxAuthTokenControlsProps {
  authToken: O.Option<string>;
  onAuthTokenChange: (authToken: string) => void;
}

export const ToolboxAuthTokenControls = ({
  authToken,
  onAuthTokenChange,
}: ToolboxAuthTokenControlsProps) => {
  const tokenExpiredResult = useMemo(
    () => O.map(isTokenExpiredPipeline)(authToken),
    [authToken]
  );

  return (
    <ToolboxControlsContainer elevation={1}>
      <ChangeAuthenticationTokenButton
        authenticationToken={authToken}
        onAuthenticationTokenChange={onAuthTokenChange}
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
    </ToolboxControlsContainer>
  );
};

const ToolboxControlsContainer = styled(Paper)(({ theme }) => ({
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
