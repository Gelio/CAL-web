import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Link,
  styled,
  Typography,
} from "@material-ui/core";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";

export const AuthTokenAcquiryInformation = () => (
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
