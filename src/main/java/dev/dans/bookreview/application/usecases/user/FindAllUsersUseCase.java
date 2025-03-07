package dev.dans.bookreview.application.usecases.user;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllUsersUseCase {
    private final UserRepository userRepository;

    public FindAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
