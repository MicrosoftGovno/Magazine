package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {
    private static EntityManagerFactory managerFactory;

    public static EntityManager getEntity() {
        if ( managerFactory == null ) {
            managerFactory = Persistence.createEntityManagerFactory("magazine");
        }
        return managerFactory.createEntityManager();
    }

    public static void closeManagerFactory() {
        if ( managerFactory.isOpen() ) {
            managerFactory.close();
        }
    }
}
