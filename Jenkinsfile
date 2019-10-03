pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn spring-boot:run'
      }
    }
  }
  environment {
    M2_HOME = '/home/sanilkumar_onlinework/servers/apache-maven-3.6.2'
  }
}