#!/usr/bin/env groovy

def call()
{
checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'mygitid', url: 'https://github.com/ramjigit/pipeline-library-demo.git']]])
}