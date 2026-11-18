#!/bin/sh
set -eu
cd "$(dirname "$0")"
printf '\n=== Problem1 ===\n'; sh Problem1/run.sh
printf '\n=== Problem2 ===\n'; sh Problem2/run.sh
printf '\n=== Problem3 (--test) ===\n'; sh Problem3/run.sh --test
