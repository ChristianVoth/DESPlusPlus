/*package database;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="student", schema="studentssep")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="studentname")
    private String studentName;

    @Column(name="arrival")
    private LocalDateTime studentArrival;


    public StudentInfo(String studentName, LocalDateTime studentArrival) {
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

    public LocalDateTime getStudentArrival() {
        return studentArrival;
    }

    public void setStudentArrival(LocalDateTime studentArrival) {
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
*/

