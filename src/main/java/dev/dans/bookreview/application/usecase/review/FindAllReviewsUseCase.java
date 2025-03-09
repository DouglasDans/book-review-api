package dev.dans.bookreview.application.usecase.review;

import dev.dans.bookreview.domain.entities.Review;
import dev.dans.bookreview.domain.repository.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllReviewsUseCase {
    private final ReviewRepository reviewRepository;

    public FindAllReviewsUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> execute() {
        return reviewRepository.findAll();
    }
}
