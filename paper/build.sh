#!/usr/bin/env bash
set -euo pipefail

latexmk -xelatex -interaction=nonstopmode ./EE-dyplom.tex
