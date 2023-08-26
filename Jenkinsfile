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
                        sh "docker login -u $USER -p '2w^.$yMpaHfms2+'"
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
