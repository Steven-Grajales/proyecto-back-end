#!/usr/bin/groovy

pipeline {
    agent any
    
    stages {
        stage('Instalacion y compilacion') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					sh 'mvn -B -DskipTests clean package'
				}
            }
        }
        stage('Ejecucion de pruebas unitarias e integracion') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					sh 'mvn test'
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
						sh 'mvn sonar:sonar'
					}
                }
            }
        }
        stage('Nexus: Generacion de artefacto') {
            steps {
				withMaven(maven : 'maven-3.6.3'){
					sh 'mvn clean deploy -P release'
				}
            }
        }
    }
}
