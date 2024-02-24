package ru.homework12.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homework12.service.FileGateway;
import ru.homework12.service.TaskService;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final FileGateway fileGateway;

    @Autowired
    private final TaskService taskService;

    private final TaskRepository taskRepository;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setCreationDate(LocalDateTime.now());
        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus (@PathVariable TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();
            updatedTask.setStatus(task.getStatus());
            return taskRepository.save(updatedTask);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
