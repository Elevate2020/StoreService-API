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
        sh 'mvn clean install'
    }
    stage('Build docker Image'){
        sh 'docker build -t targetelevate/elevate-ss-api:latest .'
    }
    stage('Docker Image push'){
    withDockerRegistry(credentialsId: 'target', toolName: 'docker') {
      sh 'docker push targetelevate/elevate-ss-api:latest'
    }
    }
    stage('Kuberneetes Deploy'){
        kubernetesDeploy configs: 'Kubernetes/minikube/storeservice-api-deployment.yml', dockerCredentials: [[credentialsId: 'target']], enableConfigSubstitution: false, kubeConfig: [path: ''], kubeconfigId: 'minikube', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
    }
}
