#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /home/app
COPY mq-app/src /home/app/mq-app/src
COPY mq-app/pom.xml /home/app/mq-app
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests
#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/mq-app/target/mq-app.jar /usr/local/lib/mq-app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/mq-app.jar"]