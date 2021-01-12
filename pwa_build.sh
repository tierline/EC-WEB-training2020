#!/bin/bash

cd pwa

npm install
npm run build
node ./postbuild.js

cd ..