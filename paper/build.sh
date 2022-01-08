#!/usr/bin/env bash
set -euo pipefail

arg="${1:-""}"
if [[ "$arg" == "-f" ]] || [[ "$arg" == "--force" ]]; then
	echo "Cleaning existing build artifacts"
	git clean EE-dyplom.* -xf
fi

latexmk -xelatex -interaction=nonstopmode ./EE-dyplom.tex
