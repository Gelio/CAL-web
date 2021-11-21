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

  -- Reload the configuration
  require('lspconfig').texlab.setup(texlab_config)
EOF

let g:tex_flavor = 'latex'
let g:vimtex_view_method = 'zathura'
