#!groovy

pipeline {
    agent any
    stages {
        stage('mv terraform folder') {
            steps {
                sh 'cp -r /terraform-files/* .'
            }
        }
        stage('terraform init') {
            steps {
                sh 'terraform init'
            }
        }
        stage('terraform apply') {
            steps {
                sh 'terraform apply -auto-approve'
            }
        }
    }
}