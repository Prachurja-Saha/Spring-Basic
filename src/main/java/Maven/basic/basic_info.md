# Artifact
1. In a Java project, an artifact is a file, typically a JAR (Java Archive), WAR (Web Application Archive), 
   or EAR (Enterprise Application Archive), `that is produced during the build process`. 
2. Artifacts represent the packaged form of your project, which can be deployed or used as a
   dependency in other projects. 

`JAR File` contains the following components:
1. [Compiled Java Classes (.class files)]: 
   The bytecode versions of your Java source files, which the JVM can execute.
2. [Resources]: Non-code files that your application may need, such as images, 
   configuration files (like .properties), and other data files.
3. [Manifest File (MANIFEST.MF)]: A metadata file located in the META-INF directory, 
   which provides information about the JAR. It can include details such as the main class to be executed 
   (for executable JARs) and versioning information.
4. [Libraries (Optional)]: If it's a fat or shaded JAR, it can also include other dependent JARs bundled together.

# Maven -> (Automates Clean, compile, Test, Package, Install, Deploy)
1. Build tool which automates/automatically everything related to the building of project
2. Building project means : Transforming source code into a deployable form
      Building a project contains phases
      `Clean`  :  Removed any previously generated build artifact/ jar, ensuring fresh start
                  It will clean the jar file from target. when we compile src file -> bytecode
      `Compile`:  Translate source files to bytecode (language understand by JVM)
                  It only translates the Java source files into bytecode (.class files) and places them in the target/classes directory.
      `Test`   :  Execute automated test to verify the code
      `Package`:  combines the compile classes,resource all project file into a single JAR and store in /target
                  [External JAR store in m2 and MyProject JAR store in /target]
      `Install`:  Install the package JAR into a local repository.(typically located at .m2 repository)
                  When I run [mvn install] maven reads the dependencies in the pom.xml if a JAR isn't in your local
                  Maven will download it from remote repo(such as Maven Central/setting.xml) and stores JAR in m2. repo
                  [ 
                    Maven doesn't physically copy the JARs into your project’s folder. 
                    Instead, during the build process (compiling, testing, packaging), 
                   `Maven sets up the classpath to include the JARs from the .m2/repository`
                  ]
                  Classpath is a list of locations (directories, JAR files) where Java looks for classes and resources
                  when compiling and running your project
                  Maven automatically includes the required JARs from your .m2 repository in the classpath when it 
                  compiles and runs your project.
      `Deploy` :  When Maven runs the [deploy] phase, it uploads the project artifact(JAR/WAR) and its metadata 
                  (like pom.xml) to a Maven remote repository, such as Maven Central or a private Nexus/Artifactory
                  repository or custom repo [digihub]. Then it will be available for other developers or projects to
                  use as a dependency. from the central repository we can use in production environment. 
                  [To deploy we have to configure <distributionManagement>]
3. Advantages of Maven:
      `Dependency Management`: Maven automatically handles external libraries (dependencies) your project needs. 
                               Instead of manually downloading JARs, Maven downloads the correct versions from a 
                               central repository and adds them to your project.
      `Profile`:  Maven build profiles for different env (e.g., dev, prod), supports [plugin]
      `Configuration`: Configuration defined in a pom.xml file, centralizing project setup.

# Using Java Compiler or If we Don't use Maven 
1. Dependency Management: You need to download and include JAR files yourself.
2. Build Process: Only compiles and packages does not support test, deploys, clean etc.
3. Environment: No support for environment-specific builds. i.e dev,local,prod,qa etc
4. Plugin: No plugin support
5. Configuration : Does not support. example - pom.xml