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
        echo "Running the smoke tests"
        bat 'mvn clean install'
                                         publishHTML(target: [
                                                 reportName : 'Serenity',
                                                 reportDir:   'target/site/serenity',
                                                 reportFiles: 'index.html',
                                                 keepAll:     true,
                                                 alwaysLinkToLastBuild: true,
                                                 allowMissing: false
                                             ])
      }
    }
  }
}