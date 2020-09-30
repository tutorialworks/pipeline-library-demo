#!/usr/bin/env groovy

def call(val, x=10){

  for(i in 1..5){
    println i
  }
  
def arg = ["Groovy","Java","Python"]
println arg[1]
println arg.class
def no = [1,2,3,4]
def no2 = no +5 //=[1,2,3,4,5]
def no3 = no - [2,3] //=[1,4]
println "no is $no"
println "no2 is $no2"
println "no3 is $no3"
}
