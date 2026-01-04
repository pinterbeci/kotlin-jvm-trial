#!/usr/bin/env bash

./gradlew clean build
google-chrome build/reports/tests/test/index.html