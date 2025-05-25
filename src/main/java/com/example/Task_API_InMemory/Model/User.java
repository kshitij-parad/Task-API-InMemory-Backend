package com.example.Task_API_InMemory.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String role; // e.g. ROLE_USER, ROLE_ADMIN

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore // prevents infinite recursion
    private List<Task> tasks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(Long id) {
    this.id = id;
}

public void setUsername(String username) {
    this.username = username;
}

public void setPassword(String password) {
    this.password = password;
}

public void setRole(String role) {
    this.role = role;
}

public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
}


}
