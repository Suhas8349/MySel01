pipeline {
    agent any

    tools {
        gradle 'Gradle'
        jdk 'JDK'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Suhas8349/MySel01.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'   // ✅ use wrapper (more reliable)
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Run Application') {
            steps {
                sh 'java -jar build/libs/*.jar'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
