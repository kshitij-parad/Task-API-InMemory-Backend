package com.example.Task_API_InMemory.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Task {

    private int id;
    private String name;
    private String desc;

     
}
