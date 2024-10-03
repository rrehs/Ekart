pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: 'https://github.com/rrehs/Ekart.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'Running JUnit tests...'
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        always {
            echo 'Build and test complete.'

            // Archive JUnit test results
            junit '**/target/surefire-reports/*.xml'
            
            // Copy JUnit test results to Downloads folder on the host (assuming /home/user/jenkins is mounted)
            sh 'cp target/surefire-reports/*.xml /var/jenkins_home/Downloads'
        }
        failure {
            echo 'One or more stages failed, but continuing...'
        }
    }
}
