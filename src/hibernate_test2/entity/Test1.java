package hibernate_test2.entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        try {


//            Session session = factory.getCurrentSession();
//
//            Employee employee = new Employee("Cyril","Kafumbe","IT",1992);
//            Detail detail = new Detail("Lusaka","8903888888","cyril@yandex.ru");
//
//            employee.setEmpDetail(detail);
//
//
//
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class,1);
//
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//
//
//            System.out.println("successful finished ");
//


            Session session = factory.getCurrentSession();


            session.beginTransaction();
            Employee emp = session.get(Employee.class,3);


            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Done!");








        }
        finally {

            factory.close();

        }




    }
}
