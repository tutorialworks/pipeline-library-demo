#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
  
}

}
}