package hibernate_test;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {


        Session session = factory.getCurrentSession();

        Employee emp = new Employee("Paulina ","Kafumbe","HR",2008);

        session.beginTransaction();

        session.save(emp);

        session.getTransaction().commit();


            System.out.println("successful finished ");
            System.out.println(emp);


        }
        finally {

            factory.close();

        }




    }
}
