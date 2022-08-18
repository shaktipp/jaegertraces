def v_bitBucketUrl = 'https://git-bitbucket.aws.fico.com:8443/scm/sproj/jaegertraces.git'
def v_bitbucketBranchName = 'develop'
def v_jobName = currentBuild.fullDisplayName

pipeline
{
    agent any

    tools {
        //Maven Tool Version
        maven "maven_3.8.6"
    }

    stages
    {
        stage('Checkout')
        {
            steps {
                git credentialsId: 'obsBitBucketCredential', url: v_bitBucketUrl, branch: v_bitbucketBranchName
            }
        }


    }//End of stages block

}//End of pipeline