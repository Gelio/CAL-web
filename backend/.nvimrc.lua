local dap = require("dap")
local base_dap_config = {
	type = "java",
	request = "attach",
	hostName = "127.0.0.1",
	port = 8000,
}
local project_names = { "sirius-web-services", "sirius-web-services-api", "sirius-web-spring" }

dap.configurations.java = vim.tbl_map(function(project_name)
	return vim.tbl_extend("error", base_dap_config, {
		name = "Debug (Attach) - " .. project_name,
		projectName = project_name,
	})
end, project_names)

local javalsp = require("lsp.java")

local backend_dir = vim.fn.expand("<sfile>:h")
-- Helps load all the projects inside a single LSP client
-- Makes it easier to work on the whole project, because
-- the whole project is loaded in memory.
javalsp.config.root_dir = backend_dir
