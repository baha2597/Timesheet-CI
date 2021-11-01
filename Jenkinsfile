#!/usr/bin/env groovy
@Library('sharedl')_
pipeline {
    agent any
    stages {
        stage("init"){
          steps{
            script{
              dockerLogin("http://192.168.122.41:8082","docker-cred")
            }

          }
        }
        stage('test app') {
            steps {
               script {
                   echo "Unit test.."
                   sh 'mvn test'
                   echo "Quality Code ..."
                    withCredentials([usernamePassword(credentialsId: 'sonar', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                      sh 'mvn clean verify sonar:sonar -Dsonar.login=${PASS}'
                    }
               }
            }
        }
        stage('build app') {
            steps {
               script {
                   echo "building the application..."
                   sh 'mvn clean package'
               }
            }
        }
        stage('build image') {
            steps {
                script {
            BuildImage('192.168.122.41:8082/app.${IMAGE_NAME}')
                }
            }
        }
        stage('deploy image') {
            steps {
                script {
                    dockerPush('192.168.122.41:8082/app.${IMAGE_NAME}')
                }
            }
        }
    }
}

