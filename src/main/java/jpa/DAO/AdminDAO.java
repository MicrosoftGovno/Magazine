package jpa.DAO;

import jpa.AdminEntity;
import jpa.ConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AdminDAO {
    private EntityManager em;
    private static AdminDAO adminDAO = new AdminDAO();

    private AdminDAO() {}

    public static AdminDAO getInstance() {
        return adminDAO;
    }

    public AdminEntity getAdminById(int id) {
        AdminEntity admin;
        em = ConnectionManager.getEntity();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        admin =  em.find(AdminEntity.class, id);
        em.close();

        return admin;
    }

}
