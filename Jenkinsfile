def v_bitBucketUrl = 'https://github.com/shaktipp/jaegertraces.git'
def v_bitbucketBranchName = 'develop'
def v_jobName = currentBuild.fullDisplayName

pipeline
{
    agent any

    tools {
        //Maven Tool Version
        maven "maven363"
    }

    stages
    {
        stage('Checkout')
        {
            steps {
                git credentialsId: 'gitHubCredential', url: v_bitBucketUrl, branch: v_bitbucketBranchName
            }
        }
        


    }//End of stages block

}//End of pipeline
