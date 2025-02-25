FROM openjdk:22-jdk-slim AS build

WORKDIR /ws_server

RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean install

FROM openjdk:22-jdk-slim

WORKDIR /ws_server

EXPOSE 8082

COPY --from=build /ws_server/target/server-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]