#!/bin/sh
set -eu
cd "$(dirname "$0")"
mkdir -p build
javac -d build *.java
java -cp build Main
