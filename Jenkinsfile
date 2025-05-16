pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'   //  Jenkins Maven tool name
        jdk 'Java 11'         //  Jenkins JDK tool name
    }

   stage('Checkout Code') {
    steps {
        git branch: 'main', url:    'https://github.com/MabonaBusisiwe/ParaBank_Banking_Software.git'
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
