@Library("my-shared-library") _ 

pipeline{
    
    agent any
    
    stages{
        
        // Creating a file to test pushing
        
        stage("create-file"){
            steps{
                echo "This is ${BRANCH_NAME} brnach :)"
                sh 'echo "this is for  testing" > test.txt'
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
                push()
            }
            
        }
    }
    
    post{
        success{
            echo "YES, successfully pushed"
        }
        
        failure{
            echo "Ops, something happend wrong"
        }
    }
}
