package ru.geekbrains.koryakin.Lesson3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareDataApp {
    public static void forcePrepareData () {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .builSessionFactory();

        Session session = null;

        try {
            System.out.println("Загружаем базу");
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining());
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
            System.out.println("База создана");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        forcePrepareData();
    }
}
