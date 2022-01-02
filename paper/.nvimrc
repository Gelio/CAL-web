lua <<EOF
  local texlab_config = require('lsp.tex').config
  local texlab_settings = texlab_config.settings.texlab
  local current_directory_path = vim.fn.expand("<sfile>:p:h")

  -- Helps texlab notice the main file
  texlab_settings.rootDirectory = current_directory_path
  texlab_settings.build.args = {"-xelatex", "-interaction=nonstopmode", "-synctex=1", current_directory_path .. "/EE-dyplom.tex"}
  texlab_settings.build.onSave = true
  -- Forward search does not detect nested files due to using \input
  texlab_settings.build.forwardSearchAfter = false
  texlab_settings.latexindent = {
    ["local"] = "latexindent.yaml",
    modifyLineBreaks = true
  }
  texlab_settings.forwardSearch = {
    executable = "zathura",
    -- texlab does not support for current cursor column, so hardcode 1
    -- so the format matches the one zathura expects
    args = { "--synctex-forward", "%l:1:%f", "%p" },
  }

  -- Reload the configuration
  require('lspconfig').texlab.setup(texlab_config)

  -- Disable misspell since it shows false-positives (the thesis is in Polish)
  require('null-ls').disable('misspell')
EOF

let g:tex_flavor = 'latex'
let g:vimtex_view_method = 'zathura'

augroup TeXFT
  autocmd!
  " latexindent wraps at 79 characters anyway
  autocmd FileType tex set textwidth=79
augroup END
