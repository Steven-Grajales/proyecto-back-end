#!/usr/bin/groovy

pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					bat 'mvn -B -DskipTests clean package'
				}
            }
        }
        stage('Test') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					bat 'mvn test'
				}
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
					withMaven(maven : 'maven-3.6.3'){
						bat 'mvn sonar:sonar'
					}
                }
            }
        }
        
    }
}
