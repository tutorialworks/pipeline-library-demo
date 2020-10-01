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
                influxDbPublisher(selectedTarget: 'TestDB', customData: assignURL(BUILD_URL))
		 def assignURL(build_url) {
                def buildURL = [:]
                buildURL['url'] = build_url
               return buildURL
                }
            }
        }
       }
       }
       }
