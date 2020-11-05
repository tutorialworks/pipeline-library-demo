#!/usr/bin/env groovy
def call(){
node('master') {
	environment{
		BUILD_ID=${BUILD_ID}
		BUILD_URL=${BUILD_URL}
                JOB_NAME=${JOB_NAME}
		//Stage_name="UNIT TEST"
                //def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.DescriptorImpl)

                // version >= 2.0
               //def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.InfluxDbStep.DescriptorImpl)

               // Create target
              //def target = new jenkinsci.plugins.influxdb.models.Target()

               // Set target details

               // Mandatory fields
               //   target.description = 'my-new-target'
              //    target.url = 'http://3.131.85.206:8086'
               //target.username = 'my-username'

               // version < 2.0
                //target.password = 'my-password'

              // version >= 2.0
              //target.password = hudson.util.Secret.fromString('my-password')

                //target.database = 'mydb'

               //influxdb.addTarget(target)
               //influxdb.save()
			}


	stage('Display'){
		echo  "Build id is ${BUILD_ID}"
		echo "Build Url is ${BUILD_URL}"
		echo "Stage_name is ${Stage_name}"
	}
   
   stage('UNIT TEST') {
   	echo "Unit testing the code"
        
                //def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.DescriptorImpl)

                // version >= 2.0
     def influxdb = Jenkins.instance.getDescriptorByType(jenkinsci.plugins.influxdb.InfluxDbStep.DescriptorImpl)

               // Create target
    def target = new jenkinsci.plugins.influxdb.models.Target()

               // Set target details

               // Mandatory fields
    target.description = 'my-new-target'
    target.url = 'http://3.131.85.206:8086'
               //target.username = 'my-username'

               // version < 2.0
                //target.password = 'my-password'

              // version >= 2.0
              //target.password = hudson.util.Secret.fromString('my-password')

   target.database = 'mydb'

   influxdb.addTarget(target)
   influxdb.save()
   	//def sFields = [:]
       // sFields['field_k'] = 'UNITTEST'
       // influxDbPublisher  jenkinsEnvParameterField: 'KEY=${BUILD_ID}', jenkinsEnvParameterTag: 'KEY=${BUILD_URL}',customData: sFields,selectedTarget: 'TestDB'

     def myFields1 = [:]
     def myCustomMeasurementFields = [:]
     myFields1['unittest'] = 1
     myFields1['Total']  = 1
     myCustomMeasurementFields['scorecard'] = myFields1
     myTags = ['scorecard':['buildurl':"test",'JOB_NAME':"test1"]]
     influxDbPublisher(selectedTarget: 'my-new-target', customDataMap: myCustomMeasurementFields, customDataMapTags: myTags)
          }
}
}