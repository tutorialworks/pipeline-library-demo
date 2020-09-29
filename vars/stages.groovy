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
    step([$class: 'InfluxDbPublisher',
 customData: null,
 customDataMap: null,
 customDataMapTags: null,
customDataTags: null,
 customPrefix: '',
 customProjectName: '',
 jenkinsEnvParameterField: '',
 jenkinsEnvParameterTag: '',
measurementName: null,
 selectedTarget: 'TestDB',
 target: [$class: 'Target', database: 'rfdata', description: 'TestDB', exposeExceptions: true, globalListener: false, globalListenerFilter: '', jobScheduledTimeAsPointsTimestamp: true, password: 'password12', retentionPolicy: 'autogen', url: 'http://3.19.208.33:8086', username: 'admin', usingJenkinsProxy: true]])
}

}
