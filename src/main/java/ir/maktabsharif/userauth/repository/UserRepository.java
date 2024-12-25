package ir.maktabsharif.userauth.repository;

import ir.maktabsharif.userauth.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
