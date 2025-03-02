package com.example.Task_API_InMemory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task_API_InMemory.Model.Task;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api")
public class MyTaskController {
        
    ArrayList<Task> taskList = new ArrayList<>(); 

    private AtomicInteger idCounter = new AtomicInteger(1); // Atomic counter for unique ID generation

    @GetMapping("/hello")
    public String Hello() {
        return  "Hello priti!!";
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task) {
        task.setId(idCounter.getAndIncrement());
        taskList.add(task);
        return task;
    
    }
    
    @GetMapping("/task")
    public ArrayList<Task> getTasks() {
        return taskList;
    }


    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable int id) {

        for(Task task :taskList){
            if(task.getId() == id){
                return task;
            }
        }
    
        return null;
    }
    

    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable int id){

        for(Task task: taskList){
            if(task.getId() == id){
                taskList.remove(task);
                return "Task Deleted!!";
            }
        }

        return "Not Found";
    }
    

    @PutMapping("/task/{id}")
    public Task putTask(@PathVariable int id, @RequestBody Task putTask) {

        for(Task task : taskList){
            if(task.getId() == id){
                task.setName(putTask.getName());
                task.setDesc(putTask.getDesc());
                return task;
            }
        }
       
        return null;
    }

}
