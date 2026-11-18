#!/bin/sh
# Usage: sh run.sh          -> opens the Swing form
#        sh run.sh --test   -> console test cases, no window
set -eu
cd "$(dirname "$0")"
mkdir -p build
javac -d build *.java
java -cp build Main "$@"
