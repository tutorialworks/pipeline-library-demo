#!/usr/bin/env groovy
import jenkins.model.*
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.EnvVars
import org.jenkinsci.plugins.pipeline.modeldefinition.Utils
import java.util.UUID
jenkins = Jenkins.instance
def call(String name = 'https://github.com/ramjigit/pipeline-library-demo.git') {
  echo "Hello, ${name}."
   git ${name} pd
}