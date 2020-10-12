 pipeline {
  agent any
  tools
              { maven 'maven' }
  stages {
  stage('Stage 1') {
      steps {
          script
                                        {
                                            if (isUnix())
                                            {
                                                sh 'mvn --batch-mode jar:jar source:jar install:install'
                                            }
                                            else
                                            {
                                            bat 'mvn clean'
                                            }
                                        }
      }
    }

stage('Stage 2') {
      steps {
          script
                                        echo 'stage 2'
      }
    }

  }
}