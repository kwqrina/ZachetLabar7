/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package view;

import controller.UserController;
import publisher.PremiumButtonPublisher;
import javax.swing.*;
import java.awt.*;

public class UserApp extends JFrame {
    private final PremiumButtonPublisher premiumButton = new PremiumButtonPublisher("Показать PREMIUM");
    private final JTextArea outputArea = new JTextArea(10, 30);
    private final UserController controller;
    
   
    private final JButton exitButton = new JButton("Выход");

    public UserApp() {
        setTitle("User Management App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350); 
        setLocationRelativeTo(null);
        
        controller = new UserController(outputArea);
        initComponents();
    }

    private void initComponents() {
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        
        JButton createUsersButton = new JButton("Создать пользователей");
        
        
        customizeButton(createUsersButton);
        customizeButton(premiumButton);
        customizeButton(exitButton);
        
      
        buttonPanel.add(createUsersButton);
        buttonPanel.add(premiumButton);
        buttonPanel.add(exitButton); 
        
      
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        add(panel);
        
      
        createUsersButton.addActionListener(e -> createUsers());
        premiumButton.addActionListener(e -> showPremiumUsers());
        exitButton.addActionListener(e -> System.exit(0)); 
    }

   
    private void customizeButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        button.setFocusPainted(false);
    }

    private void createUsers() {
        controller.createUsers(premiumButton.getPublisher());
    }

    private void showPremiumUsers() {
        outputArea.append("\nPREMIUM ПОЛЬЗОВАТЕЛИ\n");
        premiumButton.getPublisher().publishEvent();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserApp app = new UserApp();
            app.setVisible(true);
        });
    }
}