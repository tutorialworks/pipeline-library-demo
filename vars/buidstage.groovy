// vars/buildstage.groovy
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
                
                influxDbPublisher customPrefix: '', customProjectName: 'TestDB', jenkinsEnvParameterField: 'KEY=\'testdata\'', jenkinsEnvParameterTag: '', selectedTarget: 'TestDB'
            }
        }

        
        
      //pi ends here below      
       }
       
      // call ends here
       }