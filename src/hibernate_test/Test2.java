package hibernate_test;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {


        Session session = factory.getCurrentSession();

        Employee emp = new Employee("Peter ","Dick","Sales",1820);

        session.beginTransaction();

        session.save(emp);

        session.getTransaction().commit();

        int myId = emp.getId();

        session = factory.getCurrentSession();

        session.beginTransaction();

            //List<Employee> emps = session.createQuery("from Employee")
                  //  .getResultList();

            List<Employee> emps = session.createQuery("from Employee " + "where name = 'Paul' AND salary < 2000")
             .getResultList();

            for (Employee e : emps)

                System.out.println(e);

        session.getTransaction().commit();




            System.out.println("successful finished ");



        }
        finally {

            factory.close();

        }




    }
}
