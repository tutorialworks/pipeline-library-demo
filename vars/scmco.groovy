#!/usr/bin/env groovy

import java.util.logging.Logger



def call(String credential = 'mygitid') {
	//Logger.getLogger().info("inside the scmCheckout step")
    def scmUrl = scm.getUserRemoteConfigs()[0].getUrl()
	//Logger.getLogger().info("SCM URL = " +  scmUrl)

	// checkout actual branch with attached HEAD
	def checkoutBranch = (!(env.BRANCH_NAME ==~ /PR-.*/)) ? env.BRANCH_NAME : env.CHANGE_BRANCH
    
    //using checkout instead of "branch" to add submodule support with parent creds
	checkout([
        $class: 'GitSCM',
	    branches: [[name: checkoutBranch]],
	    doGenerateSubmoduleConfigurations: false,
	    extensions: [
            [
                $class: 'LocalBranch', 
                localBranch: "**",
            ],
		    [
		 	    $class: 'SubmoduleOption', 
                disableSubmodules: false, 
                parentCredentials: true, 
                recursiveSubmodules: true, 
                reference: '', 
                trackingSubmodules: false
            ]
	    ],
        submoduleCfg: [],
        gitTool: 'Default',
        userRemoteConfigs: [
            [
                credentialsId: credential,
                url: scmUrl
            ]
        ]
    ]
    )

	env.GIT_REPO_NAME       = sh(returnStdout: true, script: 'git config remote.origin.url').trim().split('/').last().minus('.git')
	env.ECR_REPO_NAME       = "${env.PROJECT_NAME}/${env.GIT_REPO_NAME}"
    

	sh('git ls-files && git branch && git tag')

}