package dev.dans.bookreview.application.usecase.user;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.UserRepository;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(User user){
        verifyNullAttributes(user);
        user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    private void verifyNullAttributes(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ResourceDataNullException("User email");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new ResourceDataNullException("User password");
        }
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
