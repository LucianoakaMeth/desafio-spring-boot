package com.platform.task.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.platform.task.backend.entity.Task;
import com.platform.task.backend.repository.TaskRepository;

@SpringBootTest
public class TaskServiceTest {
	
	@Autowired
	private TaskService taskService;
	@MockBean
	private TaskRepository taskRepository;
	
	@BeforeEach
	void setUp() {
		Task task = Task.builder()
				.id(1L)
				.name("Tarea 1")
				.consumer("Usuario")
				.status("completed")
				.build();
		Mockito.when(taskRepository.findByName("Tarea 1")).thenReturn(Optional.of(task));
	}
	
	
	@Test
	@DisplayName("Prueba de obtención de información de una tarea enviando un nombre válido")
	public void findByName() {
		String taskName = "Tarea 1";
		Task task = taskService.findByName(taskName).get();
		assertEquals(taskName, task.getName());
		System.out.println("task = " + task);
	}

}
