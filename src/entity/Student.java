package entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

//@Entity(name="student_table")
//@Table(name = "student_table") // optional
@Entity  //required (default table == student)
@DynamicUpdate
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long studentId;
    @Column(name = "name",length = 45,nullable = false)
    private String studentName;
    private Double marks;

    public Student(long studentId, String studentName, Double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Double getMarks() {
        return marks;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
