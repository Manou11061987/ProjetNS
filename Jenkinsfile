pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout'    
            }
        }
        stage('Build') {
            steps {
                echo 'Clean build'
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                bat 'mvn test'
            }
        }
        
        stage('Sonar') {
            steps {
                echo 'Sonar Scanner'
                bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=bfcf8742ca8cf08d3516386fe1036533a244934c'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploy Nexus'
                bat 'mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-1.0.jar'
            }
        }
    }
}
