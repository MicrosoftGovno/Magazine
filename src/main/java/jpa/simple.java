package jpa;

import javax.persistence.*;
import java.util.List;

public class simple {
    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("magazine");
        EntityManager em = managerFactory.createEntityManager();
//      Config config = new Config();
//        AdminEntity admin = config.getAdmin(3);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        AdminEntity admin = em.find(AdminEntity.class, 1);
        System.out.println(admin);

        em.close();
        managerFactory.close();
    }
}
