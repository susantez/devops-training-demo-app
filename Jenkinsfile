def attachments = [
     [
        text: 'Jenkins slack integration..',
        fallback: 'Hey, vendor seems to be mad at you',
        color: '#ff0000',
     ]
   ]
def slackResponse = slackSend(channel: "jenkins", message: "This is devops-training job")

pipeline {
    environment {
    registry = "19912508/devops-training"
    registryCredential = 'dockerhub'
    dockerImage = ''
    }
	agent {
	    label "docker-agent"
	}
	tools {
	    maven "maven"
	    jdk "OpenJDK-11"
	}

	stages {
		stage ('Cloning Git') {
			steps {
                git branch: 'module1-unit-test', url: 'https://github.com/susantez/devops-training.git'

                }
		}
		stage ('Build') {
			steps {
               sh 'mvn clean package'
                }
		}
		stage ('Test') {
			steps {
                sh 'mvn test'
                }
                post{
                    always{
                        junit '**/target/surefire-reports/TEST-*.xml'
                    }
                }
		}
     	stage('Building image') {
            steps{
                script {
                  // sleep 2333
                  dockerImage = docker.build registry + ":$BUILD_NUMBER"
                  }
              }
        }
         stage('Push Image') {
            steps{
                script {
                  docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                  }
                }
            }
        }
        stage('Deploy Image') {
            steps{
                script {
                  docker.withRegistry( '', registryCredential ) {
                     dockerImage.pull()
                  }
                }
            }
        }
        stage('Run Image') {
            steps{
                script {
                  docker.withRegistry( '', registryCredential ) {
                     sh 'docker container stop docker-trraining'
                     sh 'docker container rm docker-trraining'
                     sh 'docker container run -it -d -p 3000:8080  --name docker-trraining '+registry + ":$BUILD_NUMBER"+''
                     echo 'DevOps Training application is up.'
                     slackSend(channel: slackResponse.channelId, message: "Build: ${env.JOB_NAME} Completed Successfuly ${env.BUILD_URL}", timestamp: slackResponse.ts)
                     slackSend(channel: slackResponse.channelId, message: "http://localhost:3000/training/v1/book/all", timestamp: slackResponse.ts)

                    }
                }
            }
        }

    }
}