import { httpOrigin, wsOrigin } from "@eclipse-sirius/sirius-components";
import create from "zustand";

export interface APIURLsStore {
  /** URL of the BalticLSC API */
  balticLSCAPIURL: string;
  /** URL of Sirius Web. It will be used for regular HTTP API calls */
  siriusWebHTTPAPIURL: string;
  /**
   * URL of Sirius Web used for GraphQL subscriptions (using a WebSocket).
   * Must use the `ws://` or `wss://` protocol.
   */
  siriusWebWSAPIURL: string;

  setURLs: (input: APIURLsInput) => void;
}

export type APIURLsInput = Pick<
  APIURLsStore,
  "siriusWebWSAPIURL" | "siriusWebHTTPAPIURL"
> &
  Partial<Pick<APIURLsStore, "balticLSCAPIURL">>;

/** Contains API URLs. Allows hot-swapping URLs in library-mode. */
export const useAPIURLsStore = create<APIURLsStore>((set) => ({
  siriusWebHTTPAPIURL: process.env.REACT_APP_HTTP_ORIGIN ?? httpOrigin,
  siriusWebWSAPIURL: process.env.REACT_APP_WS_ORIGIN ?? wsOrigin,
  balticLSCAPIURL:
    process.env.REACT_APP_BALTICLSC_API_URL ??
    `${httpOrigin}/api/balticlsc-proxy`,
  setURLs: ({
    siriusWebHTTPAPIURL,
    siriusWebWSAPIURL,
    balticLSCAPIURL = `${siriusWebHTTPAPIURL}/api/balticlsc-proxy`,
  }) => {
    set({
      balticLSCAPIURL,
      siriusWebWSAPIURL,
      siriusWebHTTPAPIURL,
    });
  },
}));
