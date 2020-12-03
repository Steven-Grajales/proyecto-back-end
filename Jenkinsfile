#!/usr/bin/groovy

pipeline {
    agent any
    
    stages {
        stage('Instalacion y compilacion') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					bat 'mvn -B -DskipTests clean package'
				}
            }
        }
        stage('Ejecucion de pruebas unitarias e integracion') {
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
        
        stage('SonarQube: Analisis de codigo estatico') {
            steps {
                withSonarQubeEnv('sonar-server') {
					withMaven(maven : 'maven-3.6.3'){
						bat 'mvn sonar:sonar'
					}
                }
            }
        }
        stage('Nexus: Generacion de artefacto') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					bat 'mvn clean deploy -P release'
				}
            }
        }
    }
}
