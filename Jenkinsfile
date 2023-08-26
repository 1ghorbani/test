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
                    withCredentials([usernamePassword(credentialsId: 'my-github', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        echo "Trying to push to remote repository..."
                        sh "git push"
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
