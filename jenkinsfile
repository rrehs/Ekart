pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Run the build commands
                echo 'Building...'
                sh 'make build'  // Replace with your actual build command
            }
        }

        stage('Test') {
            steps {
                // Run tests and catch errors
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh 'make test'  // Replace with your actual test command
                }
            }
        }
    }

    post {
        always {
            echo 'Build complete.'
        }
        failure {
            echo 'One or more stages failed, but continuing...'
        }
    }
}
