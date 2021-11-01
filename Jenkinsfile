pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "marwen", 
                    url: "https://github.com/baha2597/Timesheet-CI.git",
                    credentialsId: "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"; 
            }
        }

 
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package -DskipTests"
                // sh "mvn clean package -DskipTests" pour une machine linux
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.spring -DartifactId=timesheet -Dversion=0.0.4 -DgeneratePom=true -Dpackaging=war  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-0.0.1.war"
            }
        }
    }
    stage("Email Notification"){
		 steps{emailext body: '''Hi welcome to jenkins email alerts
    Thanks
    Maro''', subject: 'timesheet job', to: 'riahi.marwen1@esprit.tn'
                }
	    }
   }
    post {
        always {
            cleanWs()
        }
    }
    
}
