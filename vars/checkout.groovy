#!/usr/bin/env groovy
def call(String giturl) {
  echo "Hello, ${name}."
   git ${giturl} pd
}