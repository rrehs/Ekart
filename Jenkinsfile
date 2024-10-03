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
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'Running JUnit tests...'
                    bat 'mvn test'
                }
            }
        }
    }

    post {
        always {
            echo 'Build and test complete.'
            
            // Copy JUnit test results to the Downloads folder
            bat 'copy target\\surefire-reports\\*.xml C:\\Users\\rrehs\\Downloads'  // Adjust the path as necessary
        }
        failure {
            echo 'One or more stages failed, but continuing...'
        }
    }
}
