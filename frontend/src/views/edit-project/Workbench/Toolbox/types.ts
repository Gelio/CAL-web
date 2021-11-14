import type { GQLComputationUnitReleaseInput } from "./interop";

export interface GQLCreateUnitCallInput {
  id: string;
  rootObjectId: string;
  editingContextId: string;
  unitRelease: GQLComputationUnitReleaseInput;
}

export interface GQLCreateUnitCallSuccessPayload {
  id: string;
  createdUnitCall: {
    id: string;
    kind: string;
    label: string;
  };
}
