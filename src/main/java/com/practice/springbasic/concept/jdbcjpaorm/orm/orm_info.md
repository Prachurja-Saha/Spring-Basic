# Object Relation Mapping
[why ORM?]
`Solved problem` -> Java Object -- [directly] --> relational Database -> Java Object

# Hibernate is a popular
JDBC we have to write sql query but using hibernate we don't have to do that i.e. we can save object in DB without
writing sql -> save(entity_object), We can use @Entity annotation to map object to table 

`NOTE`: While creating entity class if we provide any custom constructor i.e. Entity(int id, String name)
        then we have to provide no argument constructor. reason:[when hibernate fetch data from DB it creates a empty
        Entity object and then fills the data if we don't provide empty constructor Hibernate will not know how to 
        create a entity object]

* Session Factory -> is Hibernate. so Hibernate is all about constructing session factory
* Session Factory will check [hibernate.cfg.xml configuration file] to get all the DB connection details 
* inside that xml file [<session-factory> DB connection details </session-factory>]
* inside session factory [<mapping> we have to define entity class </mapping>]

# HQL
