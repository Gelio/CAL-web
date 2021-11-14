import * as O from "fp-ts/lib/Option";

export type GQLDataBinding = "REQUIRED" | "PROVIDED";
export type GQLMultiplicity = "SINGLE" | "MULTIPLE";

const balticLSCDataBindingToGQLMap: Record<number, GQLDataBinding> = {
  0: "REQUIRED",
  1: "REQUIRED",
  2: "PROVIDED",
  3: "PROVIDED",
};
export const balticLSCDataBindingToGQL = (
  dataBinding: number
): O.Option<GQLDataBinding> =>
  O.fromNullable(balticLSCDataBindingToGQLMap[dataBinding]);

const balticLSCMultiplicityToGQLMap: Record<number, GQLMultiplicity> = {
  0: "SINGLE",
  1: "MULTIPLE",
};
export const balticLSCMultiplicityToGQL = (
  multiplicity: number
): O.Option<GQLMultiplicity> =>
  O.fromNullable(balticLSCMultiplicityToGQLMap[multiplicity]);
