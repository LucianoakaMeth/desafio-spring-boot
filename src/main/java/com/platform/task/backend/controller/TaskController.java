package com.platform.task.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.platform.task.backend.entity.Task;
import com.platform.task.backend.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/findAllTasks")
	public List<Task> findAllTasks(){return taskService.findAllTasks();}
	
	@PostMapping("/saveTask")
	public Task saveTask(@Valid @RequestBody Task task) {
		return taskService.saveTask(task);
	}
	
	@PutMapping("/updateTask/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		return taskService.updateTask(id,task);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "Succesfully deleted";
		
	}
}
