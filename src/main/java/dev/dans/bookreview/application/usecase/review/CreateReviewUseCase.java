package dev.dans.bookreview.application.usecase.review;

import dev.dans.bookreview.domain.entities.Review;
import dev.dans.bookreview.domain.repository.ReviewRepository;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import org.springframework.stereotype.Component;

@Component
public class CreateReviewUseCase {
    private final ReviewRepository reviewRepository;

    public CreateReviewUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review execute(Review review) {
        verifyNullAttributes(review);
        return reviewRepository.save(review);
    }

    private void verifyNullAttributes(Review review) {
        if (review.getComment() == null || review.getComment().isEmpty()) {
            throw new ResourceDataNullException("Comment");
        }
        if (review.getUser().getId() == null) {
            throw new ResourceDataNullException("User Id");
        }
        if (review.getBook().getId() == null) {
            throw new ResourceDataNullException("Book Id");
        }
    }
}
