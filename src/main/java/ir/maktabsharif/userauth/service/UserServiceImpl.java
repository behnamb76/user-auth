package ir.maktabsharif.userauth.service;

import ir.maktabsharif.userauth.dto.UserDTO;
import ir.maktabsharif.userauth.model.User;
import ir.maktabsharif.userauth.repository.UserRepository;
import ir.maktabsharif.userauth.repository.UserRepositoryImpl;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void register(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword()).build();
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
