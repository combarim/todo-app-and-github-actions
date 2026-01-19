# Todo App with GitHub Actions

This project is a simple Todo application built with Spring Boot and showcases a complete CI/CD pipeline using GitHub Actions.

## Project Overview

The main goal of this project is to demonstrate a fully automated DevOps workflow. The application itself is a standard CRUD application for managing tasks.

### Features

*   Create, Read, Update, and Delete tasks.
*   RESTful API for task management.
*   Basic UI (using Thymeleaf) to interact with the application.

## CI/CD Pipeline

The CI/CD pipeline is defined in the `.github/workflows/ci-cd.yml` file and is triggered on every push to the `main` branch.

### Pipeline Stages

1.  **Build:** The application is compiled, and dependencies are downloaded using Maven.
2.  **Test:** Unit tests are executed to ensure code quality and prevent regressions.
3.  **Code Analysis:** The code is analyzed for potential bugs and security vulnerabilities using Qodana.
4.  **Docker Build & Push:** A Docker image is built from the `Dockerfile` and pushed to Docker Hub.
5.  **Deploy:** The application is deployed to a server (this step is currently a placeholder).

### Technologies Used

*   **Backend:** Spring Boot, Java 17
*   **Database:** H2 (in-memory)
*   **CI/CD:** GitHub Actions
*   **Containerization:** Docker
*   **Code Analysis:** Qodana

## Getting Started

### Prerequisites

*   Java 17
*   Maven
*   Docker

### Running the Application

1.  Clone the repository:
    ```bash
    git clone https://github.com/your-username/todo-app-and-github-actions.git
    ```
2.  Navigate to the project directory:
    ```bash
    cd todo-app-and-github-actions
    ```
3.  Run the application using Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  The application will be available at `http://localhost:8080`.

### Building the Docker Image

1.  Build the application:
    ```bash
    ./mvnw clean install
    ```
2.  Build the Docker image:
    ```bash
    docker build -t todo-app .
    ```
3.  Run the Docker container:
    ```bash
    docker run -p 8080:8080 todo-app
    ```
