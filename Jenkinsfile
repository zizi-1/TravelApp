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
                sh "docker build -t zzahid1234/atoz ."
            }
        }
		stage('--Push Image to DockerHub--') {
            steps {
		    withDockerRegistry([ credentialsId: "zohaibs-dockerhub", url: "" ]) {
                sh "docker push zzahid1234/atoz"
            }
	    }
        }

}
}

