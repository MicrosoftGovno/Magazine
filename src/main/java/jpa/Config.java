package jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Config {
    @PersistenceContext
    private EntityManager em;

    public AdminEntity getAdmin(Integer id) {
        AdminEntity admin = em.find(AdminEntity.class, id);

        return admin;
    }
}
