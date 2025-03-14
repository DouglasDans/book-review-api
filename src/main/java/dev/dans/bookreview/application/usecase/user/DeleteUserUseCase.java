package dev.dans.bookreview.application.usecase.user;

import dev.dans.bookreview.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteUserUseCase {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public DeleteUserUseCase(UserRepository userRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    public void execute(Long id) {
        reviewRepository.deleteAllByUserId(id);
        userRepository.deleteById(id);
    }
}
