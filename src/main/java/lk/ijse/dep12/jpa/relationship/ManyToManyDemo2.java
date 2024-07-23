package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.util.List;

public class ManyToManyDemo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();

            try{
                tx.begin();
                System.out.println("Entity manager Factory" + emf);
                System.out.println("Entity manager" + em);

                Student s1 = new Student("S001", "Nimal", "Kumara", "Galle", "011-1234567", Date.valueOf("1999-01-01"), 25);

                em.persist(s1);

                tx.commit();

            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
