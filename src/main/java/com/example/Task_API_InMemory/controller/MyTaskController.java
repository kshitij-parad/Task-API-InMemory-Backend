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
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOs = tasks.stream()
                .map(Mapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(taskDTOs);
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO, Principal principal) {
        // 1. Get username from the currently logged-in user
        String username = principal.getName();

        // 2. Fetch the full User entity from DB
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Should never happen if secured
        }

        // 3. Convert incoming DTO to Entity and assign the logged-in user
        Task task = Mapper.toTaskEntity(taskDTO);
        task.setUser(userOptional.get());

        // 4. Save task and convert result to DTO
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(Mapper.toTaskDTO(savedTask));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Mapper.toTaskDTO(optionalTask.get()));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());

        if (taskDTO.getUser() != null && taskDTO.getUser().getId() != null) {
            userRepository.findById(taskDTO.getUser().getId()).ifPresent(task::setUser);
        }

        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(Mapper.toTaskDTO(updatedTask));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.deleteById(id);
        return ResponseEntity.ok("Task deleted successfully.");
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Priti!!";
    }
}
