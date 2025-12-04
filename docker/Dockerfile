# Utiliser l'image officielle OpenJDK 21
FROM openjdk:21-jdk-slim

# Crée un dossier pour l'application
WORKDIR /app

# Copier le JAR généré par Maven
COPY target/todo-app.jar app.jar

# Exposer le port par défaut de Spring Boot
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
