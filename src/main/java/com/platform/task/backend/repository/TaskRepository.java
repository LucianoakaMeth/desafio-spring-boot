package com.platform.task.backend.repository;


import com.platform.task.backend.entity.Task;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
	
	Optional<Task> findByName(String name);

}
