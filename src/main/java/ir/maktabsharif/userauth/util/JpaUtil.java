package ir.maktabsharif.userauth.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManager() {
        if (emf != null) {
            emf.close();
        }
    }
}
