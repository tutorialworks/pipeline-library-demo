#!/usr/bin/env groovy

def call(String name = 'human') {
  printCallStack()
  echo "Hello, ${name}."
}

