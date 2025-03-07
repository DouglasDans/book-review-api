package dev.dans.bookreview.application.usecases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.repository.UserRepository;

@Component
public class DeleteUserUseCase {
    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long id) {
        userRepository.deleteById(id);
    }
}
