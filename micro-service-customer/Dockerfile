######
##
##  Stage 1: Building the app
##
#######

FROM maven:3.8.3-adoptopenjdk-16 AS builder
WORKDIR /build/
COPY pom.xml /build/
# fetch all dependencies
#RUN mvn dependency:go-offline -B

COPY src /build/src/
RUN mvn package -DskipTests
WORKDIR /build/target/
RUN java -Djarmode=layertools -jar micro-service-client-0.0.1-SNAPSHOT.jar extract
######
##
##  Stage 2: Running the app
##
#######

FROM adoptopenjdk:16_36-jre-hotspot
RUN useradd -rm -d /home/zbook-pn-15-g3 -s /bin/bash -g root -G sudo -u 1001 simple-user
USER simple-user
WORKDIR application
EXPOSE 8085
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
COPY --from=builder /build/target/dependencies/ ./
COPY --from=builder /build/target/spring-boot-loader/ ./
COPY --from=builder /build/target/snapshot-dependencies/ ./
COPY --from=builder /build/target/application/ ./