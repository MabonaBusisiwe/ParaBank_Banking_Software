pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'   // Must match Jenkins Maven tool name
        jdk 'Java 11'         // Must match Jenkins JDK tool name
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/MabonaBusisiwe/ParaBank_Banking_Software.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
