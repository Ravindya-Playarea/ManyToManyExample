package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_course")
@IdClass(StudentCoursePK.class)
public class StudentCourse implements Serializable {
//    @EmbeddedId
//    private StudentCoursePK studentCoursePK;

    @Id
    @ManyToOne
//    @MapsId("studentId")
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;

    @Id
    @ManyToOne
//    @MapsId("courseCode")
    @JoinColumn(name = "course_code",referencedColumnName = "code")
    private Course course;

    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

//    public StudentCourse(StudentCoursePK studentCoursePK, String registeredBy, Date date) {
//        this.studentCoursePK = studentCoursePK;
//        this.registeredBy = registeredBy;
//        this.date = date;
//    }
//    public StudentCourse(Student student, Course course, String registeredBy, Date date) {
//        this.studentCoursePK = new StudentCoursePK(student.getId(), course.getCode());
//        this.registeredBy = registeredBy;
//        this.date = date;
//    }


//    public StudentCourse(Student student, Course course, String registeredBy, Date date) {
//        this.studentCoursePK = new StudentCoursePK(student.getId(), course.getCode());
//        this.student = student;
//        this.course = course;
//        this.registeredBy = registeredBy;
//        this.date = date;
//    }
}
