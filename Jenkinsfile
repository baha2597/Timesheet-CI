#!/usr/bin/env groovy
@Library('galactech-shared-lib')_
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
     stage("init"){
      steps{
        script{
          dockerLogin("http://192.168.122.41:8082","docker-cred")
        }

      }
    }
    stages {
        stage('increment version') {
            steps {
                script {
                    echo 'incrementing app version...'
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                    echo "############ ${IMAGE_REPO}"
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
        stage('commit version update') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'git-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'git config user.email "riadh.amami@esprit.tn"'
                        sh 'git config user.name "riadhamami"'
                        sh "git remote set-url origin https://${USER}:${PASS}@github.com/baha2597/Timesheet-CI.git"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:riadh'
                    }
                }
            }
        }
    }
}

