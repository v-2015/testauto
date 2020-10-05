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

              publishHTML target: [
               allowMissing: false,
               alwaysLinkToLastBuild: false,
               keepAll: true,
               reportName : 'Serenity Report',
               reportDir:   'target/site/serenity',
               reportFiles: 'index.html'
             ]
       }


     }



}

 }
