package com.platform.task.backend.service;

import java.util.List;
import java.util.Optional;

import com.platform.task.backend.entity.Task;

public interface TaskService {
	List<Task> findAllTasks();
	Task saveTask(Task task);
	Task updateTask(Long id, Task task);
	void deleteTask(Long id);
	Optional<Task> findByName(String name);
}
