#!/usr/bin/env groovy
def call(){
node('master') {
   
   stage('UNIT TEST') {
   	echo "Unit testing the code"
    influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: 'KEY=${BUILD_ID}', jenkinsEnvParameterTag: 'KEY=${BUILD_URL}', selectedTarget: 'js1'
}

}
}