package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class HelloJpa {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();

            try{
                tx.begin();
                System.out.println("Entity manager Factory" + emf);
                System.out.println("Entity manager" + em);
                tx.commit();

            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
