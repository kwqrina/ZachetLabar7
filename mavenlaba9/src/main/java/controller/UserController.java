/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;          
import model.UserType;       
import factory.UserFactory;  
import publisher.EventPublisher;
import javax.swing.JTextArea; 
import java.util.function.Consumer; 


public class UserController {
    
    private User[] currentUsers;
    private final JTextArea outputArea;

   
    public UserController(JTextArea outputArea) {
        this.outputArea = outputArea; 
    }

    
    public void createUsers(EventPublisher publisher) {
        outputArea.setText(""); // Очистка текстовой области
        
        //создание 5 пользователей через фабрику
        currentUsers = UserFactory.createUsers(5);

      
        for (User user : currentUsers) {
            
            outputArea.append("Создан: " + user + "\n");
            
            
            if (user.getUserType() == UserType.PREMIUM) {
                
                Consumer<Void> handler = v -> {
                    
                    outputArea.append(user.getName() + " | " + user.getEmail() + "\n");
                };
                
                publisher.subscribe(handler);
            }
        }
        
        
        outputArea.append("\nPREMIUM подписчиков: " + publisher.getSubscribersCount() + "\n");
    }
}