node{
    stage("Update jenkins"){
                properties([parameters([string(defaultValue: '63.35.235.236', description: 'please provide IP', name: 'Enviroment', trim: true)])])
                sh "echo Parameter added"

    }
    stage("Install git"){
        sh "ssh ec2-user@${Environment}sudo yum install git  python-pip -y"
    }
    stage("Pull Repo"){
        sh "ssh ec2-user@${Environment}  git clone https://github.com/miguelgrinberg/flask-examples.git

    }
    stage("Install Requirements"){
        //sh "virtualenv /tmp/venv"
        //sh ". venv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${Environment} pip install -r~/flask-examples/requirements.txt"{
        }
    }
    stage("Run App"){
        sh "ssh  ec2-user@${Environment}  python ~/flask-examples/01-hello-world/hello.py"
    }
}