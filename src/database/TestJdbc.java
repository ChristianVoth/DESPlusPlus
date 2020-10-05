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

        int zahl=150;

        String jdbcUrl = "jdbc:mysql://localhost:3306/studentssep?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentInfo.class).buildSessionFactory();


        Session session = factory.getCurrentSession();
        session.beginTransaction();


        LocalDateTime now = LocalDateTime.now();
        for(int i = 8; i < zahl; i++) {
            StudentInfo student = new StudentInfo("Student" + i, now.plusSeconds(i));
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