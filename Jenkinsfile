pipeline {
	agent any

	stages {
        stage('---Mvn Clean---') {
            steps {
                sh "mvn clean"
            }
        }
	stage('---Mvn Test---') {
            steps {
		sh "mvn test"
            }
        }
	stage('---Mvn Package---') {
            steps {
		sh "mvn package"
            }
        }
	stage('--Build Backend Image--') {
            steps {
		sh "sudo chmod 777 /var/run/docker.sock"
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
