pipeline
 {
        agent any

        tools
            { maven 'maven' }

        options
            {
                buildDiscarder(logRotator(numToKeepStr: '4'))
                skipStagesAfterUnstable()
                disableConcurrentBuilds()
            }
        triggers { pollSCM(*/1 * * * *) }

        stages
            {
                stage('install local')
                {
                        steps
                        {
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

            }

