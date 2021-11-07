local dap = require("dap")
dap.configurations.java = {
	{
		type = "java",
		request = "attach",
		name = "Debug (Attach) - Remote",
		hostName = "127.0.0.1",
		port = 8000,
	},
}

local javalsp = require("lsp.java")

local backend_dir = vim.fn.expand("<sfile>:h")
-- Helps load all the projects inside a single LSP client
-- Makes it easier to work on the whole project, because
-- the whole project is loaded in memory.
javalsp.config.root_dir = backend_dir
