import * as O from "fp-ts/lib/Option";
import create from "zustand";
import { persist } from "zustand/middleware";

export interface TokenStore {
  token: O.Option<string>;
  setToken: (token: string) => void;
}

export const useTokenStore = create<TokenStore>(
  persist(
    (set) => ({
      token: O.none,
      setToken: (token) => set({ token: O.some(token) }),
    }),
    { name: "auth-token" }
  )
);
