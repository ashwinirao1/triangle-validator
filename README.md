# Spring Boot Triangle Validator

#API Description

The triangle validator RESTful API takes three triangle side lengths as its input and validates it against the following rules:

- Must adhere to triangle inequality theorem
- Sides of a triangle cannot be zero or negative
- Sides could include floating point length values
- Must not be invalid values

#How to run

> Pre requisites :

-Mac OS /Unix (Needs to be tested for Windows) 
-Java 8 on classpath
Check that could be performed for this ,execute as following:
Ashwini-Rao $ java -version
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
If Java 8 not on classpath,then got terminal and edit .bash_profile file and add below :

export JAVA_HOME=$(/usr/libexec/java_home)

OR

export JAVA_HOME=$(path to JDK 1.8 Home)

-Access to Terminal/Command Prompt

> Running the application :

#Start the application via :

/validator.sh start

#Stop the application via :

/validator.sh stop

#Run the triangle validator service via passing lengths of three sides in comma separated values as text as an argument :

/validator.sh  2,4,5

@See Example API Runs (Refer EXAMPLE_API_RUNS_TERMINAL.txt) for more examples