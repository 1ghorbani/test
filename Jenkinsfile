pipeline{
    
    agent any
    
    stages{
        
        // Creating a file to test pushing
        
        stage("create-file"){
            steps{
                sh 'echo "this is for testing" > test.txt'
            }
        }
        
        // pushing to Git repository 
        
        stage("push"){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        echo "Trying to create a docker image and push to remote repository..."
                        sh "docker logout"
                        sh "docker build -t asgharniazi/alpine:1.0 ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push asgharniazi/alpine:1.0"
                    } 
                    
                    
                }
            }
            
        }
    }
    
    post{
        success{
            echo "Ok, successfully pushed"
        }
        
        failure{
            echo "Ops, something happend wrong"
        }
    }
}
