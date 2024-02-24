package ru.homework12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.akhmedyanov.homework05.model.Task;
import ru.akhmedyanov.homework05.model.TaskStatus;
import ru.akhmedyanov.homework05.repository.TaskRepository;
import ru.homework12.service.TaskService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;



@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    public TaskRepository taskRepository;

    @InjectMocks
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
