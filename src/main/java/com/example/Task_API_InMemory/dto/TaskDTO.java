package com.example.Task_API_InMemory.dto;

public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private UserDTO user;

    // constructors
    public TaskDTO() {}

    public TaskDTO(Long id, String name, String description, UserDTO user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }
}
