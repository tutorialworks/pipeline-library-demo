// vars/Build.groovy
def call() {
 pipeline {
    
    agent any

    environment {
        BUILD_URL = "${BUILD_URL}"
        cstage = "Buildstage"

    }

    stages {
        stage('Build') {
              steps {
                echo 'Building project...'
                
                
                    }
                       }
                     }
     //stages ends here below                  
     post {
            always {
                
                influxDbPublisher(selectedTarget: 'TestDB', customData: assignURL(BUILD_URL))
            }
        }

                     
        
      //pi ends here below      
       }
       def assignURL(build_url) {
       def buildURL = [:]
       buildURL['url'] = build_url
       return buildURL
        }
      // call ends here
       }