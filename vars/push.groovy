def call(){
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        echo "Trying to push docker image to remote repository..."
        sh "echo '$PASS' | docker login -u $USER --password-stdin"
        sh "docker push 1ghorbani/alpine:1.0"
    }                  

}
