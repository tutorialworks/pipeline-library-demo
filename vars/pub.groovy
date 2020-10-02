#!/usr/bin/env groovy
def call(){
node('master') {
   
   stage('Publish') {
    influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: '', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
}

}
}