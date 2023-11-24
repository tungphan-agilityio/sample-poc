pipeline {
    agent any

    environment {
        TAG_NAME = sh(returnStdout: true, script: 'git describe --always').trim()
    }

    stages {
        stage('Build') {
            steps {
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

        stage('Deploy test with buildingTag()') {
            when { buildingTag() }
            steps {
                echo 'buildingTag() - Deploying only because this commit is tagged...'

            }
        }
    }
}