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
                sh "sudo docker build -t travel-app ."
            }
        }
	stage('--RUN--') {
            steps {
                sh "sudo docker run -d -p 9090:8082 --name TravelAppbackend travel-app"
            }
      }

}
}
