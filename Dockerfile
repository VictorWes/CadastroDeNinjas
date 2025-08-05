FROM eclipse-temurin:21
LABEL maintainer="contato@DevWes"
WORKDIR /app
COPY target/cadastroDeNinjas-0.0.1-SNAPSHOT.jar /app/aula-docker.jar
ENTRYPOINT ["java", "-jar", "aula-docker.jar"]