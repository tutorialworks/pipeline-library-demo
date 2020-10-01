// vars/Build.groovy
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
        post {
            always {
                def myFields = [:]
                   myFields['field_a'] = 11
                influxDbPublisher(selectedTarget: 'TestDB', customData: myFields)
		                }
             }
           }
       }

       }