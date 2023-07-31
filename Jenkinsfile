pipeline{
	agent any
	environment {
		DOCKERHUB_PASS = credentials('docker-pass')
	}
	stages{
		stage("Building the Student Survey Image"){
			steps{
				script{
					checkout scm
					sh 'rm -rf *.jar'
					sh 'mvn clean package'
					sh 'echo ${BUILD_TIMESTAMP}'
					sh 'docker login -u kubernetes1100 -p ${DOCKERHUB_PASS}'
					sh 'docker build -t kubernetes1100/demo .'
				}
			}
		}
		stage("Pushing image to docker"){
			steps{
				script{
					sh 'docker push kubernetes1100/demo'
				}
			}
		}
		stage("Deploying to rancher"){
			steps{
				script{
					sh 'kubectl rollout restart deploy demo -n kubernetes-namespace'
				}
			}
		}
	}
}