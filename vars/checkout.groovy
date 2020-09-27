#!/usr/bin/env groovy
import jenkins.model.*
jenkins = Jenkins.instance
def call(String giturl = 'https://github.com/ramjigit/pipeline-library-demo.git') {
  echo "Hello, ${name}."
   git ${giturl} pd
}