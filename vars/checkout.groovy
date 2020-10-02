#!/usr/bin/env groovy

def call() {
stage('Checkout') {
    echo "Source code checkout"
    def stagename='Checkout'
    echo "$stagename is completed"
    steps{
    influxDbPublisher customPrefix: '', customProjectName: 'TestDB', jenkinsEnvParameterField: 'KEY=\'testdata\'', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
}
}
}
