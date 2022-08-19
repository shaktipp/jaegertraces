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

        stage('Backend Image')
        {
            steps
            {
                dir("${env.WORKSPACE}/docker-compose/jaegerBackend")
                {
                    sh "pwd"
                    echo "Build Docker Image: shaktipp/jaeger_backend_image:latest"
                    sh "docker build -t shaktipp/jaeger_backend_image:latest ."

                    withDockerRegistry([ credentialsId: "dockerHubCredentials", url: "" ])
                    {
                        echo "Push Docker Image: shaktipp/jaeger_backend_image:latest"
                        sh "docker push shaktipp/jaeger_backend_image:latest"
                    }


                }
            }
        }

        stage('Frontend Image')
        {
            steps
            {
                dir("${env.WORKSPACE}/docker-compose/jaegerFrontend")
                {
                    sh "pwd"
                    echo "Build Docker Image: shaktipp/jaeger_frontend_image:latest"
                    sh "docker build -t shaktipp/jaeger_frontend_image:latest ."

                    withDockerRegistry([ credentialsId: "dockerHubCredentials", url: "" ])
                    {
                        echo "Push Docker Image: shaktipp/jaeger_frontend_image:latest"
                        sh "docker push shaktipp/jaeger_frontend_image:latest"
                    }

                }
            }
        }
        
       
        


    }//End of stages block

}//End of pipeline
