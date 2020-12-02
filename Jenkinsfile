#!/usr/bin/groovy

pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('SonarQube Analytics') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
                }
            }
        }
        
    }
}
