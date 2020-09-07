package ru.geekbrains.koryakin.Lesson1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private List <User> users;

    public UserRepository (){
        this.users = new ArrayList<>();
        users.add(new User(1L, "Bob", "bob@gmail.com"));
        users.add(new User(2L, "John", "john@gmail.com"));
    }

    public void printAllUsers (){
        for (User u : users) {
            System.out.println(u);
        }
    }
}
