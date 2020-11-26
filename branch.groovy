#!/usr/bin/env groovy

def call(String name) {
  echo "Branch ${name}"
  git clone --branch ${name} https://github.com/zeeamd/test4jira.git
}
