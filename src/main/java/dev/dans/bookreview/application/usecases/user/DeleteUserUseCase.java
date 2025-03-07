package dev.dans.bookreview.application.usecases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.repository.UserRepository;

@Component
public class DeleteUserUseCase {
    @Autowired
    private UserRepository userRepository;

    public void execute(Long id) {
        userRepository.deleteById(id);
    }
}
