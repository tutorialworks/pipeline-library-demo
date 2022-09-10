#!/usr/bin/env groovy

def call(String image= 'node:16.13.1-alpine', String args='--entrypoint="" -v /tmp:/tmp') {
  echo "load image: ${image}."
  docker.image(image).inside(args){
	echo "Hello, world in docker!"
	sh(script: "pwd;  ls -lrt ; ls -lrt /tmp2 ; uname -a")
  }
}

