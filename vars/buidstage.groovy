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
                script{
                 def myFields = [:]
                myFields['field_a'] = 11 
                }
                
                       }
                       }
        
           }
       }

       }