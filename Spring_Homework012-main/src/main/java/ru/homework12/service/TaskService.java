package ru.homework12.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akhmedyanov.homework05.model.Task;
import ru.akhmedyanov.homework05.model.TaskStatus;
import ru.akhmedyanov.homework05.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return  repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.getTasksByStatus(status);
    }

}
