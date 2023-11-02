# student-service-spring-boot3
# student-service-api with spring boot 3.1.5
This project is an open source project to manage students and their examinations.
To realize this API, we choosed spring boot 3.
## Requirements :
- Postgresql : version 16
- Java : version 17
- openAI3 for documentation reacheable with the path : http:/port/root/swagger-ui.html
  (For more information you can go the the application.properties of the project)
## Externalized Configurations
DEV_DB_URL, DEV_USERNAME, DEV_PASSWORD : You have to pass it as arguments to your jar
  
## Description of architecture of the project
    In this project we have packages such as : 
    - Alerts    (background-method to send mails when an examination is updated to the student)
    - configs  (configuration of the application)
    - feature (which have entiies, repositories, dtos, services and controllers)
    - security (for spring boot security filters) 
    - Utils 
    - generics