package dev.dans.bookreview.application.usecase.review;

import dev.dans.bookreview.domain.entities.Review;
import dev.dans.bookreview.domain.repository.ReviewRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateReviewUseCase {
    private final ReviewRepository reviewRepository;

    public CreateReviewUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review execute(Review review) {
        return reviewRepository.save(review);
    }
}
