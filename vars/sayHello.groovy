#!/usr/bin/env groovy

def call(String name = 'human') {
  printenv
  echo "Hello, ${name}."
}

