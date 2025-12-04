package marius.ma.todoappandgithubactions;

import marius.ma.todoappandgithubactions.dto.TaskDto;
import marius.ma.todoappandgithubactions.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppAndGithubActionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppAndGithubActionsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TaskService taskService) {
        return args -> {
            taskService.createTask(new TaskDto(null, "Learn Spring Boot", "Study Spring Boot framework", false));
            taskService.createTask(new TaskDto(null, "Build REST API", "Develop a RESTful API for tasks", false));
            taskService.createTask(new TaskDto(null, "Deploy to Production", "Deploy the application to a production environment", false));
        };
    }
}
