#!/usr/bin/env groovy
def call(){
node('master') {
	environment{
		BUILD_ID=${BUILD_ID}
		BUILD_URL${BUILD_URL}
			}
	stage('Display'){
		echo  "Build id is ${BUILD_ID}"
		echo "Build Url is ${BUILD_URL}"
	}
   
   stage('UNIT TEST') {
   	echo "Unit testing the code"
    influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: 'KEY=${BUILD_ID}', jenkinsEnvParameterTag: 'KEY=${BUILD_URL}', selectedTarget: 'TestDB'
}

}
}