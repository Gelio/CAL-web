import type { GQLDataBinding, GQLMultiplicity } from "./enums";

/**
 * Contains only the properties that are used in CAL web.
 */
export interface ToolboxEntry {
  description: string | null;
  pins: ToolboxEntryPin[];

  /**
   * May not be a valid UUID.
   * @example face_detector_rel_001
   * @example 110f65c2-3fc6-411c-9ded-8c8cf96db52d
   */
  uid: string;

  /**
   * @example 0.11
   * @example v0.1
   */
  version: string;
  unit: ToolboxEntryUnit;
}

export interface ToolboxEntryPin {
  name: string;

  tokenMultiplicity: number;
  dataMultiplicity: number;
  binding: number;
}

export interface ToolboxEntryUnit {
  icon: string;
  name: string;
  shortDescription: string | null;
  longDescription: string | null;
}

export interface GQLComputationUnitReleaseInput {
  id: string;
  name: string;
  version: string;
  pins: GQLDeclaredDataPinInput[];
}

export interface GQLDeclaredDataPinInput {
  id: string;
  name: string;
  binding: GQLDataBinding;
  tokenMultiplicity: GQLMultiplicity;
  dataMultiplicity: GQLMultiplicity;
}
