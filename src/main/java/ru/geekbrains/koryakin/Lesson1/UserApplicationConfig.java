package ru.geekbrains.koryakin.Lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.geekbrains.koryakin.Lesson1"})
public class UserApplicationConfig {

}