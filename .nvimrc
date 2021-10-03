lua <<EOF
  local path = vim.fn.expand("<sfile>:p:h")
  -- Require an actual lua file to have better IDE support
  dofile(path .. '/nvimrc.lua')
EOF
