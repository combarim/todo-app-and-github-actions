package marius.ma.todoappandgithubactions.dto;

public record TaskDto(
        Long id,
        String title,
        String description,
        boolean done
) {
}
