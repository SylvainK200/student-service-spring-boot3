FROM amazoncorretto:17
COPY ./target/*.jar student-service.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","student-service.jar"]


















#FROM maven:3.6.3-openjdk-17 AS build
#COPY . /home/app/code
#WORKDIR /home/app/code
#RUN mvn -f /home/app/code/pom.xml clean package -DskipTests
#FROM amazoncorretto:17
#WORKDIR /home/app/code
#COPY --from=build /home/app/code/target/*.jar app.jar
#EXPOSE 8085
#ENTRYPOINT ["java","-jar","app.jar"]