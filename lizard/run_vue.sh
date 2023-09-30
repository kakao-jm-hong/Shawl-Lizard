#!/bin/bash
if [ "$1" == "serve" ]; then
  cd ./src/front && npm run serve
elif [ "$1" == "build" ]; then
  cd ./src/front && npm run build
elif [ "$1" == "install" ]; then
  cd ./src/front && npm run install
else
  echo "Invalid option: $1"
  exit 1
fi
