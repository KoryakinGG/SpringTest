package ru.geekbrains.koryakin.Lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserApplicationConfig.class);

        UserRepository user = context.getBean("userRepository", UserRepository.class);

        user.printAllUsers();
        context.close();
    }
}
