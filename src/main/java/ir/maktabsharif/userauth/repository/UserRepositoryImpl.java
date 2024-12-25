package ir.maktabsharif.userauth.repository;

import ir.maktabsharif.userauth.model.User;
import ir.maktabsharif.userauth.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager em = JpaUtil.getEntityManager();
    @Override
    public void save(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));
        try {
            User foundUser = em.createQuery(cq).getSingleResult();
            return Optional.ofNullable(foundUser);
        } catch (Exception e) {
            return Optional.empty();
        }

    }
}
