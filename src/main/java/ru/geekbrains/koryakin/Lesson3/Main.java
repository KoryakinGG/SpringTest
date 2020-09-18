package ru.geekbrains.koryakin.Lesson3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) throws Exception {
        PrepareDataApp.forcePrepareData();

        Long maxId = null;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;


        System.out.println("Получаем по ИД покупателя");
        session = factory.getCurrentSession();
        session.beginTransaction();
        Buyer buyer = session.get(Buyer.class, 1L);

//        System.out.println("Удаляем по Id");
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        maxId = session.createQuery("SELECT MAX(s.id) FROM SimppleItem s", Long.class).getSingleResult();
//        session.delete(session.get(Buyer.class, maxId));
//        session.getTransaction().commit();
    }
}
