lua <<EOF
  local texlab_settings = require('lsp.tex').config.settings.texlab
  local current_directory_path = vim.fn.expand("<sfile>:p:h")

  -- Helps texlab notice the main file
  texlab_settings.rootDirectory = current_directory_path
  -- Building with texlab does not work.
  -- Use vimtex to build.
  texlab_settings.build.args = {"-xelatex", "-interaction=nonstopmode", "-synctex=1", current_directory_path .. "/EE-dyplom.tex"}
  texlab_settings.build.onSave = false
  texlab_settings.build.forwardSearchAfter = false
EOF

augroup TexFT
  " Some tex files were recognized as `plaintex` instead of `tex`.
  " vimtex did not start for plaintex filetype.
  " This fixes the filetype to always be tex.
  autocmd! *
  autocmd BufNewFile,BufRead *.tex set filetype=tex
augroup END
