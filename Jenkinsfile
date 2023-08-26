pipeline{
    
    agent any
    
    stages{
        
        // Creating a file to test pushing
        
        stage("create-file"){
            steps{
                sh 'echo "this is for testing" > test.txt'
            }
        }

        // Creating docker image file
        stage("create-image"){
            steps{
                echo "Trying to create docker image..."
                sh "docker build -t 1ghorbani/alpine:1.0 ."
            }
        }
        
        // pushing to Git repository 
        
        stage("push"){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        echo "Trying to push docker image to remote repository..."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push 1ghorbani/alpine:1.0"
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
