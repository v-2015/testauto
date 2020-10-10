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
                                            bat 'mvn --batch-mode jar:jar source:jar install:install'
                                            }
                                        }
      }
    }
  stage('Stage 2') {
      steps {
        echo "Running the smoke tests"
                          sh 'mvn clean verify -Denv="test" -Dtags="smokeTest" serenity:aggregate'

                                          publishHTML (target: [
                                            allowMissing: false,
                                            alwaysLinkToLastBuild: false,
                                            keepAll: true,
                                            reportDir: 'target/site/serenity/' + files[i],
                                            reportFiles: 'index.html',
                                            reportName: files[i]
                                          ])
      }
    }
  }
}