import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {
       Student student = new Student(2,"Mithun Bandara",90.00);
//       saveStudent(student);
//        findStudent(1);
//        findAllStudents();
//        updateStudent("Kamali",1);
        deleteStudent(1);
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
    private static void findAllStudents(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Student tudent"); // HQL : hibernate quary language
            List<Student> students = query.list();
            System.out.println(students);

        }
    }

    private static void updateStudent(String name, long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student selectedStudent = session.find(Student.class, id);
            if(selectedStudent!=null){
                selectedStudent.setStudentName(name);
                Transaction transaction = session.beginTransaction();
                session.update(selectedStudent);
                transaction.commit();
            }else {
                System.out.println("can not find data");
            }
        }
    }

    private static void deleteStudent(long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student selectedStudent = session.find(Student.class, id);
            if(selectedStudent!=null){
                Transaction transaction = session.beginTransaction();
                session.delete(selectedStudent);
                transaction.commit();
            }else {
                System.out.println("can not find data");
            }
        }
    }



}
