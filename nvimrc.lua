local null_ls = require("null-ls")
local null_ls_helpers = require("null-ls.helpers")

-- Add a new prettierd instance for formatting XML files
-- Re-registering does not work with null-ls. A new name is required.
-- https://github.com/jose-elias-alvarez/null-ls.nvim/blob/a65a7f68c1a56d5ced34088b1a3d17ab71bf40a8/lua/null-ls/builtins/formatting.lua#L423
local prettierd_xml = null_ls_helpers.make_builtin({
	name = "prettierd_xml",
	method = null_ls.methods.FORMATTING,
	filetypes = {
		"xml",
	},
	generator_opts = {
		command = "prettierd",
		args = { "$FILENAME" },
		to_stdin = true,
	},
	factory = null_ls.formatter,
})

null_ls.register(prettierd_xml)
