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
						bat 'mvn -Dsonar.host.url=http://localhost:9000 org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
					}
                }
            }
        }
        
    }
}
