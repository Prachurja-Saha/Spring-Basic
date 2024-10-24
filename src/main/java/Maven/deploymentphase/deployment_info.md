# Maven Remote Repository
A Maven remote repository is a place where Maven stores and retrieves artifacts (like JAR files and their metadata).
These repositories are used to store packaged code (artifacts) that can be shared and downloaded by others.
- Popular remote Maven repositories include
1. `Maven Central`: A widely used public repository where many open-source libraries are hosted.[default]
2. `Nexus or Artifactory`: These are artifact management tools commonly used in companies to host their own 
                           Maven repositories.
3. `Custom Repo`: Used in ur project
- In the deploy phase, Maven uploads the built artifact (like a JAR or WAR) to such a remote repository for sharing 
  and reusing in other projects.

[ We define the deployment configuration in pom.xml in this way ] `this is different from creating maven remote repo`
<distributionManagement>
    <repository>
        <id>releases</id>
        <url>https://nexus.mycompany.com/repository/maven-releases/</url> -> Nexus or Artifactory remote repo url
    </repository>
</distributionManagement>

# DEPLOYMENT OF CODE TO PROD/QA/DEV
`Step-1`  [mvn deploy -> upload jar/war file to mvn remote repository]
* Maven remote repositories (such as Maven Central, Nexus, Artifactory, etc.). 
  These repositories store your compiled code (JAR/WAR files) and make them available for download 
  by other projects or systems. However, they do not execute or run the code. [u need to take permission to use
  maven central or any other repo its up to u whether u want ur code  to be open or private in remote repo]
* These repositories are not prod/qa/dev environments where applications are run. 
  Instead, they act as storage locations for built artifacts.
* After your JAR or WAR is uploaded to a Maven repository, you still need to deploy the artifact to actual servers 
  (e.g., application servers, cloud platforms) to run your application in production or other environments.

`Step-2` [ CI/CD pipeline automates the process of deploying your artifact (JAR/WAR) to your env (Dev, QA, Prod).]
* CI (Continuous Integration): Builds, tests, and prepares the JAR/WAR for deployment.
* CD (Continuous Deployment/Delivery): Automates the process of pushing the artifact to a server where it can run.
* CI/CD tools automate the build and deployment processes are ->[Jenkins, GitLab CI, GitHub Actions, or CircleCI] 
* [CI/CD pipeline will copy the (JAR/WAR) to the application server.]
- Ultimate goal is automating build, test and deploying application to the application server/environment
- Inside Step-2 Deployment can be done in many ways
  [Direct deployment] to an application server (like Tomcat, JBoss, etc.).
  [Running the JAR] directly using java -jar (for Spring Boot or standalone applications).
  [Containerized deployment] using Docker and orchestration platforms like Kubernetes, AWS ECS, Azure AKS, etc.


# Application Server
TODO: I WILL WRITE LATER