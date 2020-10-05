pipeline
 {
  agent any

  tools
   {
    maven 'maven'
   }

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



stage('Documentation')
     {
      steps
       {
        echo "Running the smoke tests"
                  sh 'mvn clean verify -Denv="test" -Dtags="smokeTest" serenity:aggregate'

              script {

                              for (i = 0; i < files.size(); i++) {
                                  publishHTML target: [
                                      allowMissing:false,
                                      alwaysLinkToLastBuild: false,
                                      keepAll:true,
                                      reportDir: 'target/site/serenity/' + files[i],
                                      reportFiles: 'index.html',
                                      reportName: files[i]
                                  ]
                              }
                          }


        }


     }



}

 }
