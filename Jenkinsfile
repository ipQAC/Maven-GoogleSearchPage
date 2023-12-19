pipeline {
    agent any

    stages {
        stage('Get Source Code') {
            steps {
                git 'https://github.com/ipQAC/Maven-GoogleSearchPage.git'
            }
        }
        stage('Build') {
            steps {
                bat script : 'mvn compile'
            }
        }
        stage('Run Test') {
            steps {
                bat script : 'mvn test -Dbrowser=localchrome'
            }
        }
        stage('Report') {
            steps {
                testNG reportFilenamePattern: '**/testng-results.xml'
            }
        }
    }
    
    post
    {
        always
        {
            emailext body: 'This Build got Success/Failure', subject: 'Pipeline Build Status', to: 'ipatel@qac.com'
        }
    }
}
