pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                 echo 'TAG_NAME is ' + ${env.TAG_NAME}
                echo 'Build stage'
            }
        }
        stage('Test') {
            steps {
                echo 'Test stage'
            }
        }
        stage('Deploy') {
            when { tag "release-*" }
            steps {
                echo 'Deploying only because this commit is tagged...'

            }
        }
    }
}