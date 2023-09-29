#!/bin/bash
if [ "$1" == "serve" ]; then
  cd ./tahiti-web/src/front && npm run serve
elif [ "$1" == "build" ]; then
  cd ./tahiti-web/src/front && npm run build
else
  echo "Invalid option: $1"
  exit 1
fi
