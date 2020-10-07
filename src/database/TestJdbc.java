/*package database;

import core.Model;
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;
import mensaComponents.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestJdbc {

    /**
     * Mensa constructor.
     * <p>
     * Creates a new Mensa model via calling the constructor of the superclass.
     *
     * @param name java.lang.String : The name of the model
     */
/*
    public static void main(String[] args) {

        int zahl=430;

        String jdbcUrl = "jdbc:mysql://localhost:3306/studentssep?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentInfo.class).buildSessionFactory();


        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Instant timeForInsert = Instant.parse("2020-06-10T10:50:35Z");

        //LocalDateTime now = LocalDateTime.now();
        int timezahl = 30;
        for(int i = 341; i < zahl; i++) {
            timezahl = timezahl + ( 120 + (int) Math.random() * (800));
            StudentInfo student = new StudentInfo("Student" + i, timeForInsert.plusSeconds(timezahl));
            session.save(student);
        }
        session.getTransaction().commit();

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

 */
