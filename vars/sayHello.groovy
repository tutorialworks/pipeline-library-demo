#!/usr/bin/env groovy

def call(String name = 'human') {
  sh "printenv"
  echo "Hello, ${name}."
}

