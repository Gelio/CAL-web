module.exports = {
  extends: ["@commitlint/config-conventional"],

  rules: {
    "type-enum": [
      2,
      "always",
      [
        "build",
        "chore",
        "docs",
        "experiment",
        "feat",
        "fix",
        "perf",
        "refactor",
        "revert",
        "style",
        "test",
      ],
    ],
    "scope-empty": [1, "never"],
    // NOTE: allow adding links in commit messages
    // https://github.com/conventional-changelog/commitlint/issues/2112#issuecomment-690001646
    "footer-max-line-length": [0, "always"],
  },

  parserPreset: {
    parserOpts: {
      // NOTE: allow adding links in commit messages
      // https://github.com/conventional-changelog/commitlint/issues/2112#issuecomment-690001646
      noteKeywords: ["link:"],
    },
  },
};
