pipeline {
  agent any
  stages {
    stage('Stage 1') {
      steps {
        script {
          echo 'Stage 1'
        }

      }
    }

    stage('Stage 2') {
      steps {
        script {
          echo 'Stage 2'
        }

      }
    }

    stage('Build with unit testing') {
                steps {
                    // Run the maven build
                    script {
                        echo 'Build with unit testing'

                    }

                }
            }

          stage('Integration tests') {
                // Run integration test
                steps {
                    script {
                        echo 'Integration tests'

                    }
                }
            }
                    stage('ACC tests') {
                                when {
                                    // check if branch is master
                                    branch 'master'
                                }
                                steps {
                                    // give some time till the deployment is done, so we wait 45 seconds
                                    sleep(45)
                                    script {
                                    echo 'ACC tests'
                                    }
                                }
                            }

                    stage('Sonar scan execution') {
                        // Run the sonar scan
                        steps {
                            script {
                                echo 'Sonar scan execution'
                                }
                            }
                        }
                    }
                    // waiting for sonar results based into the configured web hook in Sonar server which push the status back to jenkins
                    stage('Sonar scan result check') {
                        steps {
                            timeout(time: 2, unit: 'MINUTES') {
                                retry(3) {
                                    script {
                                        echo 'Sonar scan result check'
                                        }
                                    }
                                }
                            }
                        }
                    }


  }// stages

      post {
          // Always runs. And it runs before any of the other post conditions.
          always {
              // Let's wipe out the workspace before we finish!
              deleteDir()
          }
          success {
              sendEmail("Successful");
          }
          unstable {
              sendEmail("Unstable");
          }
          failure {
              sendEmail("Failed");
          }
      }

      // The options directive is for configuration that applies to the whole job.
          options {
              // For example, we'd like to make sure we only keep 10 builds at a time, so
              // we don't fill up our storage!

              // And we'd really like to be sure that this build doesn't hang forever, so
              // let's time it out after an hour.
              timeout(time: 25, unit: 'MINUTES')
          }

}// pipeline

def sendEmail(status) {
    mail(
            to: "$EMAIL_RECIPIENTS",
            subject: "Build $BUILD_NUMBER - " + status + " (${currentBuild.fullDisplayName})",
            body: "Changes:\n " + getChangeString() + "\n\n Check console output at: $BUILD_URL/console" + "\n")
}