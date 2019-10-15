pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      environment {
        M2_HOME = '/home/sanilkumar_onlinework/servers/apache-maven-3.6.2'
      }
      steps {
        sh 'mvn spring-boot:run'
      }
    }
  }
}