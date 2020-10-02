#!/usr/bin/env groovy
def call() {
 pipeline {
    
    agent any

    environment {
        BUILD_URL = "${BUILD_URL}"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building project...'
            }
        }
        
        }
        post {
            always {
                influxDbPublisher customPrefix: '', customProjectName: 'TestDB', jenkinsEnvParameterField: 'KEY=\'Build\'', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
            }
        }
    }

}