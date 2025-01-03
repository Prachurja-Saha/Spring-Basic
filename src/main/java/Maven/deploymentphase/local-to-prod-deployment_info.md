
# Step 1
1. Clone the Project
2. Run Maven Command(build project) [mvn clean install]
   - Cleans the project by removing the target directory (jar)
   - Downloads project dependencies from repo specified in the settings.xml. If not found, 
     it searches the default Maven Central repository.
   - Stores these dependencies in the local Maven repository (~/.m2/repository)
   - [ `By mvn deploy` command we can deploy our project jar in  maven remote repo for this we need to configure
        distribution management in pom for this ] <- ci/cd pipeline will take the jar from here
3. Write Code: Make the necessary code changes or implement new features as required
4. Push Changes to GitHub

# Step 2: Build and Test in CI/CD Pipeline
1. CI/CD Integration: Once your code is pushed to GitHub, the CI/CD pipeline 
   (e.g., Jenkins, GitLab CI, GitHub Actions) will be triggered automatically (assuming the pipeline is set up).
2. Build: The pipeline runs the build process, executing commands such as [mvn clean install] to compile,
   test, and package the application. This ensures that the build is consistent with your local environment.
3. Run Tests: Unit tests, integration tests, and possibly other types of automated tests 
   (like security scans or static code analysis) will be executed as part of the pipeline to verify that the 
    code changes do not introduce any issues.
4. Generate Artifacts: If the build and tests pass, the pipeline will generate deployable artifacts 
   (e.g., JAR, WAR, Docker images) and store them in an artifact repository/ Maven remote repository
    [like Nexus, Artifactory, or a Docker registry].

# Step 3: Deploy to Staging Environment(qa/dev/prod)

# step 4: Final Goal
* Our Project Jar/war will store in Application server
* Application server is essential for handling web requests and running the application 
* [Kubernetes manages containerized applications, including those that run on application servers. 
  However, in a typical cloud-native architecture, applications run inside containers (like Docker) 
  orchestrated by Kubernetes, rather than directly on traditional application servers.]
* `For Springboot has an embedded Tomcat server in springboot JAR, it includes the Tomcat server (by default).`
* `when we run spring-boot web app it starts the embedded Tomcat server`
* `locally or in production, when you run a Spring Boot application,`
* `the embedded Tomcat server starts automatically and serves the web app`