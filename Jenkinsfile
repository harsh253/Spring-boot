pipeline{
    agent any{

        stages ('Compile'){
            steps{
                withMaven(maven: 'maven_3_6_1'){
                    bat 'mvn clean compile'
                }
            }
        }

        stages ('Testing'){
            steps{
                withMaven(maven: 'maven_3_6_1'){
                    bat 'mvn test'
                }
            }
        }

        stages ('Deployment'){
            steps{
                withMaven(maven: 'maven_3_6_1'){
                    bat 'mvn deploy'
                }
            }
        }
    }
}