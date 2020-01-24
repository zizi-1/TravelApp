pipeline {
	agent any

	stages {
        stage('---MVN---') {
            steps {
                sh "mvn clean"
		sh "mvn test"
		sh "mvn package"
            }
        }
        stage('--Create Network--') {
            steps {
                sh "docker network create travelapp-mysql"
            }
        }
	stage('--Create & Connect SQL Container with Table--') {
            steps {
                sh "docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:latest"
		sh "docker network connect travelapp-mysql mysql"
		sh "sleep 30s"
		sh "docker container run -i -t=false --network travelapp-mysql --rm mysql mysql -hmysql -u root -ppassword -e 'create database ta_database;'"    
	
		}
        }
	stage('--Build--') {
            steps {
                sh "docker build -t travel-app ."
            }
        }
	stage('--RUN--') {
            steps {
                sh "docker run --network travelapp-mysql -d -p 9090:8082 --name TravelAppDeploy travel-app"
            }
      }

}
}
