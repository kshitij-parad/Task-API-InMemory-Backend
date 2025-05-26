package com.example.Task_API_InMemory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Task_API_InMemory.model.Task;
import com.example.Task_API_InMemory.model.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // JpaRepository already has all CRUD methods
    List<Task> findByUser(User user);

}
