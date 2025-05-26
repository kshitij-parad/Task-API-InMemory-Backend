package com.example.Task_API_InMemory.controller;

import com.example.Task_API_InMemory.dto.TaskDTO;
import com.example.Task_API_InMemory.utils.Mapper;
import com.example.Task_API_InMemory.model.Task;
import com.example.Task_API_InMemory.model.User;
import com.example.Task_API_InMemory.repository.TaskRepository;
import com.example.Task_API_InMemory.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MyTaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/task")
    public ResponseEntity<List<TaskDTO>> getUserTasks(Principal principal) {
        String username = principal.getName();

        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User loggedInUser = optionalUser.get();

        List<Task> userTasks = taskRepository.findByUser(loggedInUser);

        List<TaskDTO> taskDTOs = userTasks.stream()
                .map(Mapper::toTaskDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(taskDTOs);
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO, Principal principal) {
        String username = principal.getName();
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Task task = Mapper.toTaskEntity(taskDTO);
        task.setUser(userOpt.get());

        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(Mapper.toTaskDTO(savedTask));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id, Principal principal) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();
        String loggedInUsername = principal.getName();

        if (!task.getUser().getUsername().equals(loggedInUsername)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Access denied: You do not own this task.");
        }

        return ResponseEntity.ok(Mapper.toTaskDTO(task));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO, Principal principal) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();

        // Get logged-in username from Principal
        String loggedInUsername = principal.getName();

        if (!task.getUser().getUsername().equals(loggedInUsername)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // update task fields
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());

        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(Mapper.toTaskDTO(updatedTask));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, Principal principal) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();
        String loggedInUsername = principal.getName();

        if (!task.getUser().getUsername().equals(loggedInUsername)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        taskRepository.delete(task);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Priti!!";
    }
}
