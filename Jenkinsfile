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
        script
         {
          if (isUnix())
           {
            sh 'mvn --batch-mode site'
           }
          else
           {
            bat 'mvn --batch-mode site'
           }
         }
       }
      post
       {
        always
         {
          publishHTML(target: [reportName: 'Serenity Report', reportDir: 'target/site/serenity', reportFiles: 'index.html', keepAll: true])
         }
       }
     }



    stage('Deploy test')
     {
      steps
       {
        script
         {
          if (isUnix())
           {
            // todo
           }
          else
           {
            bat returnStatus: true, script: 'sc stop Tomcat8'
            sleep(time:30, unit:"SECONDS")
            bat returnStatus: true, script: 'C:\\scripts\\clean.bat'
            bat returnStatus: true, script: 'robocopy "target" "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps" Test.war'
            bat 'sc start Tomcat8'
            sleep(time:30, unit:"SECONDS")
           }
         }
       }
     }

}

 }
