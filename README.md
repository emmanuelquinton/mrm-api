##Presentation of the project 

This project is a simple API for reserving meeting rooms; the features present are:
* Creation of a user
* Creation of a reservation

###diagram of the data base. 


##Technically 
this project implements a hexagonal architecture via the gradle modules; 
There are 4 modules:
* domain
* storage
* web
* application

###prerequisite
* java 11
* docker or postgresql
    
###tecnologies
* spingboot 2.2.4
* postgres
* liquibase
* dock worker
* kubernetes

##Run application

### via docker
````
docker-compose up
````
### via intellij

* run database 
````
docker-compose up mrm-db
````

* run application
````
on windows :
gradlew.bat clean build bootRun

on linux
./gradlew clean build bootRun
````


