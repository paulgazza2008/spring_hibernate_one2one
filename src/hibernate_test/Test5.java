package hibernate_test;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {

            Session session = factory.getCurrentSession();

            session.beginTransaction();

         //  Employee emp = session.get(Employee.class,9);
         //   session.delete(emp);
           // session.createQuery("delete Employee "
                 //   +"where surname = 'Kafumbe'").executeUpdate();

            session.createQuery("update Employee set salary=1952" +
                    " where surname ='Kafumbe'").executeUpdate();






        session.getTransaction().commit();




            System.out.println("successful finished ");



        }
        finally {

            factory.close();

        }




    }
}
