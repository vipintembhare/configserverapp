pipeline {
    agent any

    environment{
        PROJECT_ID='gke-jenkins-246915'
        IMAGE_NAME='configserver'
        ENV='dev'    
        IMAGE_TAG="$PROJECT_ID/$IMAGE_NAME:latest"
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
                    docker.withTool("docker") {
                    docker.withServer('tcp://doc.config-server-service:2375') {
                    def image = docker.build("${IMAGE_TAG}")
                    println "Newly generated image, " + image.id
                    
                    docker.withRegistry('https://us.gcr.io', 'gcr:gke-jenkins-key') {
                           image.push('latest')
                    }
                 }
                    }
               }
            }
        }
    }
}
