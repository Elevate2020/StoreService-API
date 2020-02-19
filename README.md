# StoreService

### 1. Pre check

```bash

    # Verify Java set up
    java -version

    # Verify maven set up
    mvn

    # Github access

    Login to https://github.com

    # docker install
    docker -v

    # check if minikube up and running
    minikube ip
    
    #If minikube is not running, run the below command to start minikube
    minukube start --vm-driver=hyperkit
    minikube addons enable ingress

    # jenkins install
    brew start service jenkins
    Launch jenkins https://localhost:8080
    

```

### 1. Fork the Code to your respective GHE organization

#### Login into GHE - https://github.com

#### Navigate to https://github.com/Elevate2020/StoreService-API

#### Click on Fork Option at top right of the application

#### Choose your home organization and Fork

#### 2. Let's get the source code from Git

```bash
    # Fork the repo to your organization
    # Rename your repo name to StoreService-<GitOrg>
    # Create a workspace under home directory
    mkdir gitrepo

    # Change to gitrepo directory
    cd gitrepo

    # Clone the git repo
    git clone https://github.com:<YourGitOrg>/StoreService.git

    # Navigate to StoreService folder
    cd StoreService
```

### 3. Let's build our application and create a binary/artifact

```bash
    # Make sure you are in StoreService folder
    # Change artifactID in pom.xml from storeservice to storeservice-<gitorg>
    # Execute maven commands to clean, test and package application to a jar file
    mvn clean package

    # Start the application
    java -jar target/storeservice-1.0.jar

    #Check if applicaiton is running
    Open browser and enter url "http://localhost:8081/MN/1"
```

### 5. Let's set up a CI/CD pipeline using Vela/Drone and Kubernetes (minikube)

```bash
    # Lets talk about vela configuration (.vela.yml)

    # Login to vela and add git-repo to dashboard
    login to localhost:8080/jenkins

    # Verify if build is triggered and succeeded
```

### 6. Deploy code into Kubernetes/Minikube
