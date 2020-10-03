#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
   sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE  jdb"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=jdb\' --data-binary \'jenkins_stages,stage=Checkout,region=us-east value=0.1 1534055562000000000\''''
}

}
}