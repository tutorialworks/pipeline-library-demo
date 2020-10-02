#!/usr/bin/env groovy
def call(){
node('master') {
   
   stage('Building the code') {
   	echo "Building the code"
    influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: '', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
}

}
}