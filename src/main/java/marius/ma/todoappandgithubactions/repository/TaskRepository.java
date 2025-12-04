package marius.ma.todoappandgithubactions.repository;

import marius.ma.todoappandgithubactions.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
