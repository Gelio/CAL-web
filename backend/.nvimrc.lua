local javalsp = require("lsp.java")

local backend_dir = vim.fn.expand("<sfile>:h")
-- Helps load all the projects inside a single LSP client
-- Makes it easier to work on the whole project, because
-- the whole project is loaded in memory.
javalsp.root_dir = function()
	return backend_dir
end
