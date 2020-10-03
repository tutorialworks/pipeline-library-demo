#!/usr/bin/env groovy
def call(){
node('master') {
   environment {
        BUILD_URL = "${BUILD_URL}"

    }

   stage('Checkout') {
   	echo "Checkout source code"
   	echo "${BUILD_URL}"
    influxDbPublisher(selectedTarget: 'TestDB', customData: assignURL(BUILD_URL))
    def assignURL(build_url) {
    def buildURL = [:]
    buildURL['url'] = build_url
    return buildURL}

}

}
}