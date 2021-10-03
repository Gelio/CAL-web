lua <<EOF
  require('lsp.java').setup({
    root_dir = vim.fn.expand("<sfile>:p:h")
  })
EOF
