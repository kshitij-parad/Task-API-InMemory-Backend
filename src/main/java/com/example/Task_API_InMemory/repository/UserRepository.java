package com.example.Task_API_InMemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Task_API_InMemory.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository already has all CRUD methods
}
