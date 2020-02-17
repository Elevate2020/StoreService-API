node{
    stage('Initialize'){
      def dockerHome = tool 'docker'
      def mavenHome = tool 'maven'
      env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }
    stage('Checkout'){
        git credentialsId: 'afb29c50-d501-4c1d-8852-ce1a6193e8a6', url: 'https://github.com/Elevate2020/StoreService-API.git'
    }
    stage('Build'){
        sh 'java -version'
        sh 'mvn clean install'
    }
    stage('Build docker Image'){
        sh 'docker build -t swaraj1123/elevate-ss-api:latest Docker/'
    }
    stage('Docker Image push'){
        withDockerRegistry(credentialsId: '064af0a5-cde4-480c-8a14-87eabe184f04', toolName: 'docker') {
            sh 'docker push swaraj1123/elevate-ss-api:latest'
        }
    }
    stage('Kuberneetes Deploy'){
        kubernetesDeploy configs: 'Kubernetes/minikube/storeservice-api-deployment.yml', dockerCredentials: [[credentialsId: '064af0a5-cde4-480c-8a14-87eabe184f04']], enableConfigSubstitution: false, kubeConfig: [path: ''], kubeconfigId: 'e9d7ade7-21d9-4f64-ae80-891fd1b25713', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
    }
}
