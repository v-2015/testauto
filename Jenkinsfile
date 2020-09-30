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



}// pipeline

