package com.platform.task.backend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.task.backend.entity.Task;
import com.platform.task.backend.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public List<Task> findAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		Task taskDb = taskRepository.findById(id).get();
		if(Objects.nonNull(task.getName()) && !"".equalsIgnoreCase(task.getName())) {
			taskDb.setName(task.getName());
		}
		
		
		return taskRepository.save(taskDb);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);	
	}
	
	 @Override
	    public Optional<Task> findByName(String name){
	      return taskRepository.findByName(name);
	    }


}
