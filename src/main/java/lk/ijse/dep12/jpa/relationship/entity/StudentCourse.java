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
public class StudentCourse implements Serializable {
    @EmbeddedId
    private StudentCoursePK studentCoursePK;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_code",referencedColumnName = "code", insertable = false, updatable = false)
    private Course course;

    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    public StudentCourse(StudentCoursePK studentCoursePK, String registeredBy, Date date) {
        this.studentCoursePK = studentCoursePK;
        this.registeredBy = registeredBy;
        this.date = date;
    }
    public StudentCourse(Student student, Course course, String registeredBy, Date date) {
        this.studentCoursePK = new StudentCoursePK(student.getId(), course.getCode());
        this.registeredBy = registeredBy;
        this.date = date;
    }
}
