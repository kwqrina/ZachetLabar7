/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.User;
import model.UserType;
import com.github.javafaker.Faker;
import java.util.UUID;
import java.util.Random;

public class UserFactory {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    
    
    public static User createUser() {
        UUID id = UUID.randomUUID();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        UserType userType = random.nextBoolean() ? UserType.PREMIUM : UserType.REGULAR;
        
        return new User(id, name, email, userType);
    }
    
    
    public static User[] createUsers(int count) {
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = createUser();
        }
        return users;
    }
}