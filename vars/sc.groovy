#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
   sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE mydb"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=mydb\' --data-binary \'js1,checkout=present checkout=1\''''
   influxDbPublisher customPrefix: '', customProjectName: '', jenkinsEnvParameterField: 'BUILD_URL', jenkinsEnvParameterTag: "test", selectedTarget: 'js1'
}

}
}