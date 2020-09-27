#!/usr/bin/env groovy

import hudson.model.User

def call(String[] submitters, closure) {

    def returnVal = closure()
    String submitter = User.getById(returnVal, false).getDisplayName()

    println("submitter = " + submitter)
	while(!submitters.contains(submitter)) {
		println("Approval required from list: " + submitters)
	    returnVal = closure()
		submitter = User.getById(returnVal, false).getDisplayName()
	}

}