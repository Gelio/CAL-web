import type { ServerError } from "@apollo/client";
import * as O from "fp-ts/lib/Option";
import create from "zustand";

export interface AuthErrorStore {
  error: O.Option<ServerError>;
  setError: (error: ServerError) => void;
}

export const useAuthErrorStore = create<AuthErrorStore>((set) => ({
  error: O.none,
  setError: (error) => set({ error: O.some(error) }),
}));
