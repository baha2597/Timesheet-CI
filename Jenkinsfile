pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git";
                git branch: "baha",
                    url: "https://github.com/baha2597/Timesheet-CI.git",
                    credentialsId: "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",
            }
        }

        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package -DskipTests"
            }
        }

        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        stage("Email Notification") {
                    steps {
                      mail bcc: '', body: 'Hey Gabsi , Your pipeline is running ! ', cc: '', from: '', replyTo: '', subject: 'Jenkins', to: 'bahaeddine.gabsi@gmail.com'
                    }
                }
        stage("DEPLOY") {
            steps {
                bat "mvn  clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=0.0.2 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.0.jar"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }

}
