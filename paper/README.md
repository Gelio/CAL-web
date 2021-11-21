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

The document will be built on save by texlab.

Make sure to start neovim first and then open TeX files. Passing the file name
directly to the `nvim` command will load the file before the configuration is
loaded and result in incorrect recognition of TeX files.

#### Forward search

For forward-search, install
[the Zathura PDF viewer](https://pwmt.org/projects/zathura/documentation/). The
reason is that the built-in PDF viewer is hard to configure to support forward-
and inverse-search with support for project multiple files.

On Ubuntu, you can install it using:

```sh
sudo apt install zathura
```

Then, do `\lv` (or `:VimtexView`, or `:TexlabForward`) to do forward search.

#### Inverse search

Add the following to the `~/.config/zathura/zathurarc`:

```text
set synctex true
set synctex-editor-command "nvim --headless -c 'VimtexInverseSearch %{line} %{input}'"
```

Then, ctrl + click will do inverse search.

Reference:
<https://www.math.cmu.edu/~gautam/sj/blog/20140310-zathura-fsearch.html>

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
