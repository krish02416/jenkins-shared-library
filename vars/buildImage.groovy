#!/user/bin/env groovy

def call(){
    echo "Building the docker image...."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable:'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t harikrishnan20010616/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push harikrishnan20010616/demo-app:jma-2.0'
    }
}