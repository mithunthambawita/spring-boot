import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppInitializer {
    public static void main(String[] args) {
       Student student = new Student(1,"Kamal Bandara",90.00);
       saveStudent(student);
    }
    private static void saveStudent(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            //save (it return a serializable object, return primary key of the saved object)
            //persist,saveOrUpdate
            Transaction transaction = session.beginTransaction();//save, update and delete
            long primaryKey = (Long) session.save(student);
            transaction.commit();
            System.out.println(primaryKey);
        }
    }

}
