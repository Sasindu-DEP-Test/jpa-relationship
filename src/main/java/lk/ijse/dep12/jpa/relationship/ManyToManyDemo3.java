package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourseEnrollment;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo3 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();

            try{
                tx.begin();
                System.out.println("Entity manager Factory" + emf);
                System.out.println("Entity manager" + em);


                Student s001 = em.find(Student.class, "S001");
                Course c001 = em.find(Course.class, "C001");
                System.out.println(c001);



                StudentCourseEnrollment studentCourseEnrollment = new StudentCourseEnrollment(s001, c001,"Amal", Date.valueOf(LocalDate.now()));
//
                em.persist(c001);
                em.persist(s001);
                em.persist(studentCourseEnrollment);

                tx.commit();

            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
