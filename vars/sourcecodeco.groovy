#!/usr/bin/env groovy
def call(){
node('master') {
   
   stage('Checkout') {
   	echo "Checkout source code"
    influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: '', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
}

}
}