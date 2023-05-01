import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
       Student student = new Student(2,"Mithun Bandara",90.00);
       saveStudent(student);
//        findStudent(1);
    }
    private static void saveStudent(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            //save (it return a serializable object, return primary key of the saved object)
            //persist (no return type)
            // saveOrUpdate
            Transaction transaction = session.beginTransaction();//save, update and delete
            session.save(student);
            transaction.commit();

        }
    }
    private static void findStudent(long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.find(Student.class,id);
            if(student!=null){
                System.out.println(student.toString());
            }else {
                System.out.println("Can not find data");
            }
        }
    }



}
