# Types of Repositories in Maven and how its works
* [Local Repository] Maven first check dependency in .m2 repo
* [Remote Repository] Maven will then check the remote repo i.e settings.xml file or your project's pom.xml
  i.e Digihub if not found then
  default remote repository is Maven Central.
  `Default Maven Central Repository` public, remote repository hosted online https://repo.maven.apache.org/maven2
  Maven uses to fetch dependencies if no other repository is configured in your pom.xml or settings.xml.
  - In pom.xml, u can define <repositories> where u can specify additional locations for Maven to search for dependencies.
  - <repositories>
    <repository>
        <id>my-custom-repo</id>
        <url>https://my.custom.repo/repository/maven-releases/</url>
    </repository>
    </repositories>
  
# CREATE MAVEN REMOTE CUSTOM REPOSITORY
