def v_bitBucketUrl = 'https://github.com/shaktipp/jaegertraces.git'
def v_bitbucketBranchName = 'develop'
def v_jobName = currentBuild.fullDisplayName

pipeline
{
    agent any

    tools {
        //Maven Tool Version
        maven "maven363"
        jdk "jdk18"
    }

    stages
    {
        stage('Checkout')
        {
            steps {
                git credentialsId: 'gitHubCredential', url: v_bitBucketUrl, branch: v_bitbucketBranchName
            }
        }
        
        stage('Maven Build')
        {
            steps{                
                sh "mvn clean install -DskipTests=true -U"               
            }
        }

        stage('Build Images')
        {
            steps
            {
                sh "cd ./docker-compose"
                sh "docker compose build"
                sh "cd .."
            }
        }
        
       
        


    }//End of stages block

}//End of pipeline
