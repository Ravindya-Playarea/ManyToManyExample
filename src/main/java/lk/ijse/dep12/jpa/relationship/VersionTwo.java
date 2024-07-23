package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class VersionTwo {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

//                Course c001 = new Course("C001","DEP","6 months");
//                Course c002 = new Course("C002","CMJD","6 months");
//                Course c003 = new Course("C003","GDSE","2 years");
//
//                Student s001 = new Student("S001","Tharindu","Galle","011-1234567",Date.valueOf("1999-07-05"));
//                Student s002 = new Student("S002","Imantha","Gampaha","022-1234567",Date.valueOf("2000-09-15"));
//                Student s003 = new Student("S003","Buddika","Colombo","033-1234567",Date.valueOf("1997-10-05"));
//                List.of(s001,s002,s003,c001,c002,c003).forEach(em::persist);

                Course c003 = em.find(Course.class,"C003");

                Student s003 = em.find(Student.class,"S003");

                StudentCourse sc3 = new StudentCourse(s003,c003,"Ravindya",Date.valueOf(LocalDate.now()));


                em.persist(sc3);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }
}
