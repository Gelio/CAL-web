import * as O from "fp-ts/lib/Option";
import { useEffect, useState } from "react";

const authTokenStorageKey = "balticLSCAuthToken";

export const useBalticLSCAuthToken = () => {
  const [authToken, setAuthToken] = useState(() =>
    O.fromNullable(localStorage.getItem(authTokenStorageKey))
  );

  useEffect(() => {
    if (O.isSome(authToken)) {
      localStorage.setItem(authTokenStorageKey, authToken.value);
    }
  }, [authToken]);

  return {
    authToken,
    setAuthToken,
  };
};
