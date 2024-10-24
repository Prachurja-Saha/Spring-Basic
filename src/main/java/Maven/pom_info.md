# XML -> Stands for "Extensible Markup Language."
Purpose  : It is a markup language designed to store and transport data. 
           XML is both human-readable and machine-readable.
Structure: It uses a tree structure with elements defined by tags, 
           making it easy to represent complex data structures hierarchically.


# Configuration 
set of information that we provide to customize how our application will behave
advantage:
Easy Changes: Instead of rewriting code, you can just change the configuration to adjust how the app works.
              we can change one env to other easily
              Often, configuration settings are stored in specific files (like pom.xml in Maven) 
              that tell the app how to behave. we can customize our own way ver easily

# POM.xml -> Configuration file

# SNAPSHOT-> DEPLOYMENT IS GOING ON While development we don't change version multiple time instead we use snapshot

# Advantages
1. `Project Information` provides basic metadata about the project, such as its group, artifact ID, 
   version, and packaging type (e.g., JAR, WAR).
   <groupId>com.example</groupId> [groupId: Identifies your project/org uniquely i.e aero.sita.digihub]
   <artifactId>myapp</artifactId> [artifactId: The name of your Service.]
   <version>1.0-SNAPSHOT</version>
   <packaging>jar</packaging>
2. `Dependencies` downloading and including external JARs automatically.
3. 
