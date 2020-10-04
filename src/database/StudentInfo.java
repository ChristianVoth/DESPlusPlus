package database;

import javax.persistence.*;

@Entity
@Table(name="student")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String studentName;

    @Column(name="arrival")
    private double studentArrival;


    public StudentInfo(String studentName, double studentArrival) {
        this.studentName = studentName;
        this.studentArrival = studentArrival;
    }
    public StudentInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentArrival() {
        return studentArrival;
    }

    public void setStudentArrival(double studentArrival) {
        this.studentArrival = studentArrival;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentArrival=" + studentArrival +
                '}';
    }
}
