# swagger-sample
Swagger Working Sample

This project is to understand how to setup the **Swagger** in Spring MVC environment

# How to run this project?

pom.xml has a dependency for embedded **tomcat7** server so just run the below command to start the server up and running
###mvn clean install tomcat7:run

Then the server starts at the url *http://localhost:8085/*

To check the swagger api json structure go to the url : *http://localhost:8085/v2/api-docs*

For Swagger-UI go to the url : *http://localhost:8085/swagger-sample/swagger-ui.html*

This link has usefulinformation on setting up Swagger in your application [simple-way to implement swagger] (http://stackoverflow.com/questions/26720090/a-simple-way-to-implement-swagger-in-a-spring-mvc-application)
