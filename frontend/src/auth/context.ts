import { Option, some } from "fp-ts/lib/Option";
import React, {
  createContext,
  PropsWithChildren,
  useContext,
  useState,
} from "react";

export interface AuthContextValue {
  token: Option<string>;
  setToken: (token: string) => void;
}

const AuthContext = createContext<AuthContextValue | null>(null);

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (context === null) {
    throw new Error("useAuthContext used but AuthContext is not provided");
  }

  return context;
};

export const AuthContextProvider = ({ children }: PropsWithChildren<{}>) => {
  const [token, setToken] = useState<Option<string>>(
    // TODO: use `none` after the testing phase is done
    some(
      // NOTE: invalid BalticLSC token, but one with a very long expiration
      // Makes testing more convenient.
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImRlbW8iLCJzdWIiOiJkZW1vIiwianRpIjoiZTA3MGFmOWUyYThiNGQ3YjkwMTQ0MmQ2Y2EyNzJiMmQiLCJzaWQiOiI0ZjlkYjJlMmJkZTg0ODMxYTNjZDZmM2FlNWEyYWExMyIsImV4cCI6MTk5ODAxMzM5NiwiaXNzIjoid3V0LmJhbHRpY2xzYy5ldSIsImF1ZCI6Ind1dC5iYWx0aWNsc2MuZXUifQ.0tmUZH9fb9-8ojtli6V1PNwhODfCgOplc2CbAov23LQ"
    )
  );

  return React.createElement(
    AuthContext.Provider,
    {
      value: {
        token,
        setToken: (t) => setToken(some(t)),
      },
    },
    [children]
  );
};
