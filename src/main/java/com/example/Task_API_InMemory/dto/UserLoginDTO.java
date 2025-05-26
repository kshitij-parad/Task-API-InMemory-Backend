package com.example.Task_API_InMemory.dto;

public class UserLoginDTO {
    private String username;
    private String password;

    // getters & setters
     public void setUsername(String username){
        this.username= username;
    }
    
    public void setPassword(String password){
        this.password= password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }


}
