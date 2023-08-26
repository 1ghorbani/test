pipeline{
    agent any
    environment{
        name = "Reza"
    }
    stages{
        stage("test"){
            steps{
                echo "this is test section"
            }
        }
        
        stage("mypy"){
            steps{
                echo "python3 --version"
            }
        }
        
        stage("myinfo"){
            steps{
                echo "my name is ${name}"
            }
        }
    }
}
