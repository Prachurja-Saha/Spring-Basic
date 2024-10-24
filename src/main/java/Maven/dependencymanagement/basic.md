# <dependencyManagement> list of dependency </dependencyManagement> inside that dependency called bom dependency
1. It is defined mainly in parent pom for controlling version all over the project. 
2. We Must declare that dependency in child POM to use that dependency in child project,
   but version is inherited from parent pom we don't need to mention version.
3. mainly useful when we need particular dependency in child pom we just have to mention that and 
   no need to mention the version, versioning we can handle from parent pom.
4. Not Using <dependencyManagement>
- All child modules inherit all dependencies from parent, Automatically inherited, no need to declare in child POM
- 