package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();

            try{
                tx.begin();
                System.out.println("Entity manager Factory" + emf);
                System.out.println("Entity manager" + em);

                Course dep = new Course("C001", "DEP", "6 Months");
                Course cmjd = new Course("C002", "CMJD", "6 Months");
                Course gdse = new Course("C003", "GDSE", "18 Months");

                List.of(dep, cmjd, gdse).forEach(em::persist);


                tx.commit();

            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
