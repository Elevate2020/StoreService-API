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

    # minikube install
    docker -v

    # jenkins install
    brew start service jenkins
    Launch jenkins https://localhost:8080

```

### 1. Fork the Code to your respective GHE organization

#### Login into GHE - https://git.target.com

#### Navigate to https://git.target.com/Dojo-TI/StoreService/tree/elevate-dryrun

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
    git clone git@git.target.com:<YourGitOrg>/StoreService.git

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
    java -jar target/storeservice-<gitorg>-1.0.jar

    #Check if applicaiton is running
    Open browser and enter url "http://localhost:8080/BLR/1"
```

### 5. Let's set up a CI/CD pipeline using Vela/Drone and Kubernetes (minikube)

```bash
    # Lets talk about vela configuration (.vela.yml)

    # Login to vela and add git-repo to dashboard
    login to localhost:8080/jenkins

    # Verify if vela build is triggered and succeeded
```

### 6. Deploy code into Kubernetes/Minikube
