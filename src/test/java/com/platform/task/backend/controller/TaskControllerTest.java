package com.platform.task.backend.controller;

import com.platform.task.backend.entity.Task;
import com.platform.task.backend.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

	@WebMvcTest(TaskController.class)
	class TaskControllerTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private TaskService taskService;

	    private Task task;

	    @BeforeEach
	    void setUp() {
	    	Task task = Task.builder()
					.id(1L)
					.name("Tarea 1")
					.consumer("Usuario")
					.status("completed")
					.build();
	    }

	    @Test
	    public void saveTask() throws Exception{
	        Task postTask = Task.builder()
	        		.name("Tarea 1")
					.consumer("Usuario")
					.status("completed")
					.build();
	        Mockito.when(taskService.saveTask(postTask)).thenReturn(task);
	        mockMvc.perform(post("/saveTask").contentType(MediaType.APPLICATION_JSON)
	                .content("{\n" +
	                        "    \"name\":\"Tarea 1\",\n" +
	                        "    \"consumer\": \"Usuario\",\n" +
	                        "    \"status\":\"completed\"\n" +
	                        "}"))
	                .andExpect(status().isOk());
	    
	}

}
