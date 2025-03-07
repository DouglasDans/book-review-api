package dev.dans.bookreview.application.usecases.user;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.UserRepository;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdUseCase {
    @Autowired
    private UserRepository userRepository;

    public User execute(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("User ID:" + id + " not found");
        }

        return user.get();
    }
}
