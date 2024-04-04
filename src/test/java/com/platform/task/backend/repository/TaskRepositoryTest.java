/**
 * 
 */
package com.platform.task.backend.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Optional;
import com.platform.task.backend.entity.Task;

@DataJpaTest
class TaskRepositoryTest {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp(){
		Task tasks =
				Task.builder()
				.name("Tarea 2")
				.consumer("Usuario")
				.status("incompleted")
				.build();
		
		testEntityManager.persist(tasks);
	}

	@Test
	public void findByName() {
		Optional<Task> tasks = taskRepository.findByName("Tarea 2");
		assertEquals(tasks.get().getName(), "Tarea 2");
		
	}

}
