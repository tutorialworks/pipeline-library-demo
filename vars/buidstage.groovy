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
                     }
     //stages ends here below                  
     post {
            always {
                
                influxDbPublisher(selectedTarget: 'TestDB', customData: 'BuildStage')
            }
        }

                     
        
      //pi ends here below      
       }
      // call ends here
       }