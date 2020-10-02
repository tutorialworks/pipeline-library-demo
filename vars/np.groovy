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
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy project...'
            }
        }
        }
        post {
            always {
                influxDbPublisher customPrefix: '', customProjectName: 'TestDB', jenkinsEnvParameterField: 'KEY=\'testdata\'', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
            }
        }
    }

}