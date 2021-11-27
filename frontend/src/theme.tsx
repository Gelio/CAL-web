import { theme } from "@eclipse-sirius/sirius-components";
import { createTheme } from "@material-ui/core/styles";

const baseTheme = createTheme({
  ...theme,
  palette: {
    type: "light",
    primary: {
      main: "#BE1A78",
      dark: "#851254",
      light: "#CB4793",
    },
    secondary: {
      main: "#261E58",
      dark: "#1A153D",
      light: "#514B79",
    },
    text: {
      primary: "#261E58",
      disabled: "#B3BFC5",
      hint: "#B3BFC5",
    },
    error: {
      main: "#DE1000",
      dark: "#9B0B00",
      light: "#E43F33",
    },
    divider: "#B3BFC5",
  },
  props: {
    MuiAppBar: {
      color: "secondary",
    },
  },
  overrides: {
    MuiSnackbarContent: {
      root: {
        backgroundColor: "#7269A4",
      },
    },
  },
});

export const siriusWebTheme = createTheme(
  {
    overrides: {
      MuiAvatar: {
        colorDefault: {
          backgroundColor: baseTheme.palette.primary.main,
        },
      },
    },
  },
  baseTheme
);
