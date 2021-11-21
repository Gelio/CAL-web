# CAL-web thesis

## Requirements

- [latexmk](https://mg.readthedocs.io/latexmk.html)
- [XeLaTeX](https://en.wikipedia.org/wiki/XeTeX)
- [biber](<https://en.wikipedia.org/wiki/Biber_(LaTeX)>)

On Ubuntu, they can be installed by running:

```sh
sudo apt install latexmk texlive-xetex biber
```

### Editor support

Editor support for editing LaTeX varies by editor.

### Neovim

The following tools come in handy:

- [vimtex](https://github.com/lervag/vimtex)

  It should work out of the box.

- [texlab](https://github.com/latex-lsp/texlab) (via
  [lsp-config](https://github.com/neovim/nvim-lspconfig/blob/master/doc/server_configurations.md#texlab))

  See additional configuration in [.nvimrc](./.nvimrc).

Compilation using vimtex is recommended. Forward search may not work due to
using a multi-file project.

## Compiling

Compiling the thesis paper is done by invoking the following command:

```sh
latexmk
```

This will produce the `EE-dyplom.pdf` document.

This works automatically due to [the `.latexmkrc` file](./.latexmkrc).

Make sure you have installed [all the required tools](#requirements).

## License

This thesis paper is based on
[EE-dyplom template for thesis papers](https://github.com/SP5LMA/EE-dyplom).

Template license: CC-BY 4.0 <https://creativecommons.org/licenses/by/4.0/> 🄯
Łukasz Makowski <lukasz.makowski@ee.pw.edu.pl>
