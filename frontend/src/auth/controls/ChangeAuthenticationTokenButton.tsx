import {
  Button,
  IconButton,
  Modal,
  Paper,
  styled,
  Tooltip,
  Typography,
} from "@material-ui/core";
import EditIcon from "@material-ui/icons/Edit";
import * as O from "fp-ts/lib/Option";
import { FormEventHandler, useState } from "react";
import { AuthTokenAcquiryInformation } from "./AuthTokenAcquiryInformation";

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

interface ChangeAuthTokenFormProps {
  initialAuthToken: O.Option<string>;
  onSubmit: (authToken: string) => void;
  onCancel: () => void;
}

const ChangeAuthTokenForm = ({
  initialAuthToken,
  onSubmit,
  onCancel,
}: ChangeAuthTokenFormProps) => {
  const onFormSubmit: FormEventHandler<HTMLFormElement> = (event) => {
    event.preventDefault();
    const formData = new FormData(event.target as HTMLFormElement);
    onSubmit(formData.get("authToken").toString());
  };
  return (
    <form onSubmit={onFormSubmit}>
      <AuthTokenTextarea
        defaultValue={O.toNullable(initialAuthToken)}
        name="authToken"
        placeholder="Enter your authentication token"
      />

      <AuthTokenAcquiryInformation />

      <AuthTokenFormButtonsContainer>
        <Button onClick={onCancel}>Cancel</Button>
        <Button type="submit" variant="contained" color="primary">
          Submit
        </Button>
      </AuthTokenFormButtonsContainer>
    </form>
  );
};

const AuthTokenTextarea = styled("textarea")(({ theme }) => ({
  width: "100%",
  marginTop: theme.spacing(1),
  resize: "vertical",
  minHeight: "10em",
  boxShadow: theme.shadows[1],
}));
const AuthTokenFormButtonsContainer = styled("div")(({ theme }) => ({
  display: "flex",
  justifyContent: "space-between",
  marginTop: theme.spacing(2),
}));
