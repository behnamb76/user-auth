package ir.maktabsharif.userauth.service;

import ir.maktabsharif.userauth.dto.UserDTO;
import ir.maktabsharif.userauth.model.User;

import java.util.Optional;

public interface UserService {
    void register(UserDTO userDTO);
    Optional<User> getUserByUsernameAndPassword(String username, String password);
}
