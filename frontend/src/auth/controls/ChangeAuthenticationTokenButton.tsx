import {
  IconButton,
  Modal,
  Paper,
  styled,
  Tooltip,
  Typography,
} from "@material-ui/core";
import EditIcon from "@material-ui/icons/Edit";
import * as O from "fp-ts/lib/Option";
import { useState } from "react";
import { ChangeAuthTokenForm } from "./ChangeAuthTokenForm";

interface ChangeAuthenticationTokenButtonProps {
  onAuthenticationTokenChange: (authenticationToken: string) => void;
  authenticationToken: O.Option<string>;
}

const idPrefix = "change-authentication-token-modal";
const title = "Change authentication token";

export const ChangeAuthenticationTokenButton = ({
  onAuthenticationTokenChange,
  authenticationToken,
}: ChangeAuthenticationTokenButtonProps) => {
  const [modalOpen, setModalOpen] = useState(false);

  return (
    <>
      <Tooltip title={title}>
        <IconButton aria-label={title} onClick={() => setModalOpen(true)}>
          <EditIcon />
        </IconButton>
      </Tooltip>
      <Modal
        open={modalOpen}
        onClose={() => setModalOpen(false)}
        aria-labelledby={`${idPrefix}-title`}
      >
        <ModalContent elevation={5}>
          <Typography id={`${idPrefix}-title`} variant="h6">
            {title}
          </Typography>
          <ChangeAuthTokenForm
            initialAuthToken={authenticationToken}
            onSubmit={(authToken) => {
              setModalOpen(false);
              onAuthenticationTokenChange(authToken);
            }}
            onCancel={() => setModalOpen(false)}
          />
        </ModalContent>
      </Modal>
    </>
  );
};

const ModalContent = styled(Paper)(({ theme }) => ({
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  padding: theme.spacing(3),
  minWidth: 400,
}));
