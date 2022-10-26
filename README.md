# Stock Application

This application is written using java 11 and gradle 7.4.1
Postgresql db is used for storing data, also swagger is used for OpenAPI specification.

## Running Application

Liquibase is used for database table and initial data creation. Follow below steps before running application

- Install postgresql db in your local. Default username is "postgres" and password is "root". It can be changed in application.properties
- Create "auzun" database and inside, create "stock" schema. This names also can be changed in application.properties
- Clone project into your local computer.
- After building successfully when running project liquibase will create stock table and initial data in it under postgres paycschema schema.
- If any problem occurs when creating table and initial data, disable liquibase at startup and you can manually run these files respectively using liquibase update (resource/db/changelog/db.changelog-table.yaml and resource/db/changelog/db.changelog-init-data.sql)
- You can see all apis using swagger link (localhost:8080/swagger-ui/index.html) after running application
- StockApplication.java is the entrypoint when configuring spring boot application


## In this Application
Below examples can be found
 - Spring boot application with rest api examples
 - Swagger implementation
 - CRUD operations
 - Query using pagination
 - Liquibase implementation and default data insert
 - Test classes