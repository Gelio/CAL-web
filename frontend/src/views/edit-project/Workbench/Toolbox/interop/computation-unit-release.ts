import * as E from "fp-ts/lib/Either";
import * as A from "fp-ts/lib/Array";
import { v4 as uuid } from "uuid";

import type {
  GQLComputationUnitReleaseInput,
  GQLDeclaredDataPinInput,
  ToolboxEntry,
  ToolboxEntryPin,
} from "./types";
import { pipe } from "fp-ts/lib/function";
import {
  balticLSCDataBindingToGQL,
  balticLSCMultiplicityToGQL,
  GQLDataBinding,
  GQLMultiplicity,
} from "./enums";

interface DeclaredDataPinParsingError {
  pinName: string;
  errors: Error[];
}
const DeclaredDataPinParsingErrorValidation = E.getApplicativeValidation(
  A.getSemigroup<DeclaredDataPinParsingError>()
);

export const getGQLComputationUnitReleaseInput = (
  toolboxEntry: ToolboxEntry
): E.Either<DeclaredDataPinParsingError[], GQLComputationUnitReleaseInput> => {
  const pinsResult = pipe(
    toolboxEntry.pins,
    A.map((toolboxEntryPin) =>
      pipe(
        getGQLDeclaredDataPinInput(toolboxEntryPin),
        E.mapLeft((errors): DeclaredDataPinParsingError[] =>
          A.of({
            pinName: toolboxEntryPin.name,
            errors,
          })
        )
      )
    ),
    A.sequence(DeclaredDataPinParsingErrorValidation)
  );

  return pipe(
    pinsResult,
    E.map(
      (pins): GQLComputationUnitReleaseInput => ({
        id: uuid(),
        name: toolboxEntry.unit.name,
        version: toolboxEntry.version,
        pins,
      })
    )
  );
};

const ErrorValidation = E.getApplicativeValidation(A.getSemigroup<Error>());

const getUnexpectedValueError = (value: unknown, propertyName: string) => () =>
  [new Error(`Unexpected value ${value} for '${propertyName}'`)];

const getGQLDeclaredDataPinInput = (
  toolboxEntryPin: ToolboxEntryPin
): E.Either<Error[], GQLDeclaredDataPinInput> => {
  const tokenMultiplicityResult = pipe(
    balticLSCMultiplicityToGQL(toolboxEntryPin.tokenMultiplicity),
    E.fromOption(
      getUnexpectedValueError(
        toolboxEntryPin.tokenMultiplicity,
        "tokenMultiplicity"
      )
    )
  );
  const dataMultiplicityResult = pipe(
    balticLSCMultiplicityToGQL(toolboxEntryPin.dataMultiplicity),
    E.fromOption(
      getUnexpectedValueError(
        toolboxEntryPin.dataMultiplicity,
        "dataMultiplicity"
      )
    )
  );
  const dataBindingResult = pipe(
    balticLSCDataBindingToGQL(toolboxEntryPin.binding),
    E.fromOption(getUnexpectedValueError(toolboxEntryPin.binding, "binding"))
  );
  return pipe(
    A.sequence(ErrorValidation)([
      tokenMultiplicityResult,
      dataMultiplicityResult,
      dataBindingResult,
    ]),
    E.map(
      ([
        tokenMultiplicity,
        dataMultiplicity,
        dataBinding,
      ]): GQLDeclaredDataPinInput => {
        return {
          id: uuid(),
          name: toolboxEntryPin.name,
          dataMultiplicity: dataMultiplicity as GQLMultiplicity,
          tokenMultiplicity: tokenMultiplicity as GQLMultiplicity,
          binding: dataBinding as GQLDataBinding,
        };
      }
    )
  );
};
