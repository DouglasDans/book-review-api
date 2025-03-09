package dev.dans.bookreview.application.usecase.review;

import dev.dans.bookreview.domain.repository.ReviewRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteReviewUseCase {
    private final ReviewRepository reviewRepository;

    public DeleteReviewUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void execute(Long id) {
        reviewRepository.deleteById(id);
    }
}
