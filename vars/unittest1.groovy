#!/usr/bin/env groovy
def call(){
node('master') {
	environment{
		BUILD_ID=${BUILD_ID}
		BUILD_URL=${BUILD_URL}
		Stage_name="UNIT TEST"
			}
	stage('Display'){
		echo  "Build id is ${BUILD_ID}"
		echo "Build Url is ${BUILD_URL}"
		echo "Stage_name is ${Stage_name}"
	}
   
   stage('UNIT TEST') {
   	echo "Unit testing the code"
   	def sFields = [:]
     sFields['field_k'] = 'UNITTEST'
     influxDbPublisher  jenkinsEnvParameterField: 'KEY=${BUILD_ID}', jenkinsEnvParameterTag: 'KEY=${BUILD_URL}',customData: sFields,selectedTarget: 'TestDB'
          }
}
}