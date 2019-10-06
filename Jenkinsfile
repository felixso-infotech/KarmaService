pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      environment {
        M2_HOME = '/home/sanilkumar_onlinework/servers/apache-maven-3.6.2'
      }
      steps {
        sh '/home/sanilkumar_onlinework/servers/apache-maven-3.6.2/bin/mvn spring-boot:run'
      }
    }
  }
}