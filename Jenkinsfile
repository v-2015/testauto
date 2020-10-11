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
        stage('Smoke') {
            try {
                bat "mvn clean verify -Dtags='type:Smoke'"
            } catch (err) {

            } finally {
                publishHTML (target: [
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: "Smoke tests report"
                ])
            }
        }

  }
}