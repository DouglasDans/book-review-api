package dev.dans.bookreview.application.usecase.user;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.UserRepository;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user){
        verifyNullAttributes(user);
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
}
