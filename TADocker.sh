#!/bin/bash

git clone -b DockerTest https://github.com/zzahid93/TravelApp.git

cd TravelApp

#Dockerfile
touch Dockerfile
echo ' # build from the Maven image
# which has a maven environment configured already
FROM maven:latest
# copy our application in
COPY . /TravelApp
# change the working directory to where we are building
# the application
WORKDIR /TravelApp
# use maven to build the application
RUN mvn clean package
# create a new build stage from the Java image
# which has java installed already
FROM java:8
# change the working directory to where the application
# is going to be installed
WORKDIR /opt/travel-app
# copy the JAR file that was created in the previous
# build stage to the application folder in this build stage
COPY --from=0 /TravelApp/target/*.jar app.jar
# create an entrypoint to run the application
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
 ' > Dockerfile


docker stop mysql
docker stop TravelAppDeploy
docker stop pleaseWork
docker system prune -a

#SQL
docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:latest

#Docker Network
docker network create travelapp-mysql

docker network connect travelapp-mysql mysql
sleep 30s
docker container run -it --network travelapp-mysql --rm mysql mysql -hmysql -u root -ppassword -e "create database ta_database;"

#Build
docker build -t travel-app .

#Run
docker run --network travelapp-mysql -d -p 9090:8082 --name TravelAppDeploy travel-app

