package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.review.*;
import dev.dans.bookreview.domain.entities.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final CreateReviewUseCase createReviewUseCase;
    private final DeleteReviewUseCase deleteReviewUseCase;
    private final FindAllReviewsUseCase findAllReviewsUseCase;
    private final FindReviewByIdUseCase findReviewByIdUseCase;
    private final UpdateReviewUseCase updateReviewUseCase;

    public ReviewService(CreateReviewUseCase createReviewUseCase,
                         DeleteReviewUseCase deleteReviewUseCase,
                         FindAllReviewsUseCase findAllReviewsUseCase,
                         FindReviewByIdUseCase findReviewByIdUseCase,
                         UpdateReviewUseCase updateReviewUseCase) {
        this.createReviewUseCase = createReviewUseCase;
        this.deleteReviewUseCase = deleteReviewUseCase;
        this.findAllReviewsUseCase = findAllReviewsUseCase;
        this.findReviewByIdUseCase = findReviewByIdUseCase;
        this.updateReviewUseCase = updateReviewUseCase;
    }

    public Review create(Review review) {
        return createReviewUseCase.execute(review);
    }

    public List<Review> findAll() {
        return findAllReviewsUseCase.execute();
    }

    public Review findById(Long id) throws Exception {
        return findReviewByIdUseCase.execute(id);
    }

    public Review update(Review review) throws Exception {
        findReviewByIdUseCase.execute(review.getId());
        return updateReviewUseCase.execute(review);
    }

    public void delete(Long id) throws Exception {
        findReviewByIdUseCase.execute(id);
        deleteReviewUseCase.execute(id);
    }
}
