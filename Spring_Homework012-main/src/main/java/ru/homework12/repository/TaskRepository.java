package ru.homework12.repository;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByStatus(TaskStatus status);
}

@SpringBootApplication
@EnableJpaRepositories
public class Homework05Application {
    public static void main(String[] args) {
        SpringApplication.run(Homework05Application.class, args);
    }
}
