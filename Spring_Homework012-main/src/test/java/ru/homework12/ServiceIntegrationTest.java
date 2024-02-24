package ru.homework12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.akhmedyanov.homework05.model.Task;
import ru.akhmedyanov.homework05.model.TaskStatus;
import ru.akhmedyanov.homework05.repository.TaskRepository;
import ru.homework12.service.TaskService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ServiceIntegrationTest {

    @MockBean
    public TaskRepository taskRepository;

    @Autowired
    public TaskService taskService;

    @Test
    public void getTasksByStatusTest() {
        Task task = new Task();
        task.setStatus(TaskStatus.COMPLETED);
        given(taskRepository.getTasksByStatus(task.getStatus())).willReturn(Collections.singletonList(task));
        List<Task> tasks = taskRepository.getTasksByStatus(task.getStatus());
        assertEquals(task, tasks.get(0));
    }
}
