#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
   sh '''curl -i -XPOST http://3.134.86.192:8086/query --data-urlencode "q=CREATE DATABASE  jdb2"
curl -i -XPOST \'http://3.134.86.192:8086/write?db=jdb2\' --data-binary \'j_stag,stage=checkout value=checkout\''''
}

}
}