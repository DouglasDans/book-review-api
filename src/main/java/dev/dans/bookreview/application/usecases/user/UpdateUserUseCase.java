package dev.dans.bookreview.application.usecases.user;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {
    private UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}
