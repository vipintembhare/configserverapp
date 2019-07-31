pipeline {
    agent any

    environment{
        PROJECT_ID='gke-jenkins-246915'
        IMAGE_NAME='configserver'
        ENV='dev'    
        IMAGE_TAG="gcr.io/$PROJECT_ID/+$IMAGE_NAME:latest"
        
    }
    tools{
       maven 'M3'
    }
    stages {
         stage ('Pull') {

            steps {
               git url: 'https://github.com/vipintembhare/configserverapp.git'
            }
        }
        stage ('Build Stage') {

            steps {
                    sh 'mvn clean install'
            }
        }
        stage ('Docker Stage') {

            steps {
                script{
                    withDockerServer('tcp://doc.config-server-service:4243') {
                    def myImage = docker.build("${IMAGE_NAME}")
                           println "Newly generated image, " + image.id
                 }
               }
            }
        }
    }
}
