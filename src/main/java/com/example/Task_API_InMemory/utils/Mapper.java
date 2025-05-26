package com.example.Task_API_InMemory.utils;

import com.example.Task_API_InMemory.dto.TaskDTO;
import com.example.Task_API_InMemory.dto.UserDTO;
import com.example.Task_API_InMemory.model.Task;
import com.example.Task_API_InMemory.model.User;

public class Mapper {

    public static UserDTO toUserDTO(User user) {
        if(user == null) return null;
        return new UserDTO(user.getId(), user.getUsername(), user.getRole());
    }

    public static User toUserEntity(UserDTO userDTO) {
        if(userDTO == null) return null;
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        // user.setRole(userDTO.getRole());
        // do NOT set password here from DTO
        return user;
    }

    public static TaskDTO toTaskDTO(Task task) {
        if(task == null) return null;
        return new TaskDTO(task.getId(), task.getName(), task.getDescription(), toUserDTO(task.getUser()));
    }

    public static Task toTaskEntity(TaskDTO taskDTO) {
        if(taskDTO == null) return null;
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        // task.setUser(toUserEntity(taskDTO.getUser()));
        return task;
    }
}
