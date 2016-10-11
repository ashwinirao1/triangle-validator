#!/bin/sh

##################################################################################
############ Validation shell script for execution for REST API ##################
##################################################################################
###### Shell Script Name : validator.sh ##########################################
###### Supportes Arguments : [start][stop][triangleSideOneLength,triangleSideTwoLength,triangleSideThreeLength]
###### Author : Ashwini Rao ######################################################
###### Last modified date : 10-Oct-2016 ##########################################
##################################################################################


NOOFARGS=$#
CONNECT_URL=http://localhost:8080

if [ "$NOOFARGS" -ne 1 ]; then
        echo "Invalid Arguments\n"
        echo "Usage Options\n"
        echo "\t$0 \n Option 1 :- /validator.sh start \n Option 2 :- /validator.sh stop \n Option 3 :- /validator.sh  triangleSideOneLength,triangleSideTwoLength,triangleSideThreeLength  \n"
else
		OPTION_ID=$1
        echo "Option selected : $OPTION_ID"
        if [ "$OPTION_ID" == "start" ]; then
         java -jar validator.jar > catalina.out 2>&1 &
         PID=`ps -aef | grep validator.jar |grep -v grep |awk '{print $2}'`
         	while [[ "" !=  "$PID" ]]
         	do
         	echo "Server started."
         	break
         	done         
       	elif [ "$OPTION_ID" == "stop" ]; then         
         	PID=`ps -aef | grep validator.jar |grep -v grep |awk '{print $2}'`
         	while [[ "" !=  "$PID" ]]
         	do
         		echo "Killing server at $PID"
  				kill -9 $PID
  				echo "Server stopped."
         		break
         	done
        else
        IFS=', ' read -r -a array <<< "$OPTION_ID"
        SIDE_ONE=${array[0]}
        SIDE_TWO=${array[1]}
        SIDE_THREE=${array[2]}
         echo "Executing triangle service with sides  side one=$SIDE_ONE ,side two = $SIDE_TWO ,side three = $SIDE_THREE \n" 
         curl --request GET \
         	   --url "$CONNECT_URL/validate?sideOne=$SIDE_ONE&sideTwo=$SIDE_TWO&sideThree=$SIDE_THREE" \
         	   --header 'accept: application/json' | json_pp
         	   
        fi

fi
