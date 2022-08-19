def v_bitBucketUrl = 'https://github.com/shaktipp/jaegertraces.git'
def v_bitbucketBranchName = 'develop'
def v_jobName = currentBuild.fullDisplayName

pipeline
{
    agent any

    def app

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

        stage('Backend Image')
        {
            steps
            {
                sh "cd ./docker-compose/jaegerBackend"
                echo "Current Directory:$PWD"
                app = docker.build("shaktipp/jaeger_backend_image:latest")
            }
        }
        
       
        


    }//End of stages block

}//End of pipeline
