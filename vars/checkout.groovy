#!/usr/bin/env groovy

def call() {
stage('Checkout') {
    echo "Source code checkout"
    def stagename='Checkout'
    echo "$stagename is completed"
    post {
            always {
                influxDbPublisher(selectedTarget: 'TestDB', customData: assignURL(BUILD_URL))
            }}
}
}
