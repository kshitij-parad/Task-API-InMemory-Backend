
package com.example.Task_API_InMemory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Task API!";
    }
}
