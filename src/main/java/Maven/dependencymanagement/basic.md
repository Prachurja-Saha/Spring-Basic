# single dependency can contain multiple dependency
i.e JPA dependency contains Hibernate core dependency b/c JPA use hibernate

# Useful config
<parent> define parent pom info </parent>
<properties> define properties i.e version</properties>

# <dependencyManagement> list of dependency </dependencyManagement> inside that dependency called bom dependency
1. It is defined mainly in parent pom for controlling version all over the project. 
2. We Must declare that dependency in child POM to use that dependency in child project,
   but version is inherited from parent pom we don't need to mention version.
3. mainly useful when we need particular dependency in child pom we just have to mention that and 
   no need to mention the version, versioning we can handle from parent pom.
4. Not Using <dependencyManagement>
-  we have to declare in child POM with version
- `Other Advantages of Parent pom`
- You can centralize build configurations (like plugins, properties, etc.) in the parent POM, 
  ensuring that all child modules share the same build settings.
- Child modules inherit plugin configurations, which allows you to manage plugin versions and configurations in one 
  place, making it easier to maintain consistency across modules.


# Plugin, Goal, phase