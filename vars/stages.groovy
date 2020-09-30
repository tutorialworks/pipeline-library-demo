#!/usr/bin/env groovy
def call() {
stage('Source co') {
    echo "Source code checkout"
}
stage('Compile') {
    echo "Compile"
}
stage('Unit Test') {
    echo "Unit test"
}
stage('Static Code Analysis') {
    echo "Static Code Analysis"
}
stage('BVT') {
    echo "BVT"
}
stage('Vulnerability Scanning') {
    echo "Vulnerability Scanning"
}
stage('Artifactory Push') {
    echo "Artifactory Push"
}    
stage('Push to influxDB') {
    echo "Pushing to infuxdb"

   influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: '', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
  }
}
