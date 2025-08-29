/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID; 


public class User {
    
    private final UUID id;           
    private final String name;      
    private final String email;      
    private final UserType userType; 

   
    public User(UUID id, String name, String email, UserType userType) {
        this.id = id;               
        this.name = name;           
        this.email = email;         
        this.userType = userType;  
    }

   
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public UserType getUserType() { return userType; }

   
    public void handlePremiumEvent() {
        
        if (userType == UserType.PREMIUM) {
            
            System.out.println(name + " | " + email);
        }
    }

   
    @Override
    public String toString() {
        return name + " | " + email + " | " + userType;
    }
}
