package dev.dans.bookreview.application.usecase.review;

import dev.dans.bookreview.domain.entities.Review;
import dev.dans.bookreview.domain.repository.ReviewRepository;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindReviewByIdUseCase {
    private final ReviewRepository reviewRepository;

    public FindReviewByIdUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review execute(Long id) {
        Optional<Review> review = reviewRepository.findById(id);

        if (review.isEmpty()) throw new ResourceNotFoundException("Review ID:" + id + " not found");

        return review.get();
    }
}
