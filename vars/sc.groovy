#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
   sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE jenkinsdb"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=jenkinsdb\' --data-binary \'job_stages,stage=Checkout,url=${BUILD_URL}" 1534055562000000000\''''
}

}
}