import { Link } from "@material-ui/core";
import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Button,
  IconButton,
  Modal,
  Paper,
  styled,
  Tooltip,
  Typography,
} from "@material-ui/core";
import EditIcon from "@material-ui/icons/Edit";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import * as O from "fp-ts/lib/Option";
import { FormEventHandler, useState } from "react";

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

      <AuthenticationTokenAcquiryInformation />

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

const AuthenticationTokenAcquiryInformation = () => (
  <Accordion>
    <AccordionSummary expandIcon={<ExpandMoreIcon />}>
      How to get the authentication token?
    </AccordionSummary>
    <AccordionDetails>
      <div>
        <Typography variant="body2">
          You can get the authentication token from{" "}
          <Link href="https://balticlsc.iem.pw.edu.pl/">
            the BalticLSC platform
          </Link>
          .
        </Typography>

        <AuthenticationTokenAcquiryStepsList>
          <li>
            <Typography variant="body2">
              Log into{" "}
              <Link href="https://balticlsc.iem.pw.edu.pl/">
                the BalticLSC platform
              </Link>
              . You can use the <em>demo</em> user, the credentials are below
              the login form.
            </Typography>
          </li>
          <li>
            <Typography variant="body2">
              Open the browser developer tools. If you are not sure how to do
              that, check out{" "}
              <Link href="https://balsamiq.com/support/faqs/browserconsole/">
                this guide
              </Link>
              .
            </Typography>
          </li>
          <li>
            <Typography variant="body2">
              There should be a long line beginning with <strong>token</strong>.
              Copy everything after the <strong>token</strong>. This is your
              authentication token.
            </Typography>
          </li>
          <li>
            <Typography variant="body2" gutterBottom>
              If you do not see the token in the console, get the token from
              your browser's <strong>localStorage</strong>. This varies by
              browser.
            </Typography>
            <Typography variant="body2" gutterBottom>
              On Google Chrome, you can see it in the{" "}
              <strong>Application</strong> tab in the developer tools, and then
              go to the <strong>Local Storage</strong> item in the left menu.
            </Typography>
            <Typography variant="body2" gutterBottom>
              On Mozilla Firefox, go to the <strong>Storage</strong> tab and
              then select the <strong>Local Storage</strong> item in the left
              menu.
            </Typography>
            <Typography variant="body2">
              There should be a <strong>token</strong> entry in the table. Its
              value is your authentiation token.
            </Typography>
          </li>
        </AuthenticationTokenAcquiryStepsList>
      </div>
    </AccordionDetails>
  </Accordion>
);

const AuthenticationTokenAcquiryStepsList = styled("ol")(({ theme }) => ({
  listStyle: "auto",
  marginLeft: theme.spacing(3),
  marginTop: theme.spacing(2),
  marginBottom: theme.spacing(2),

  "& li": {
    marginBottom: theme.spacing(1),
  },
}));
