import { Button, styled } from "@material-ui/core";
import * as O from "fp-ts/lib/Option";
import { FormEventHandler } from "react";
import { AuthTokenAcquiryInformation } from "./AuthTokenAcquiryInformation";

interface ChangeAuthTokenFormProps {
  initialAuthToken: O.Option<string>;
  onSubmit: (authToken: string) => void;
  onCancel: () => void;
}

export const ChangeAuthTokenForm = ({
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
