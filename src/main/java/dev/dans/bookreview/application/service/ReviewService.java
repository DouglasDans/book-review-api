package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.review.*;
import dev.dans.bookreview.domain.entities.Review;
import dev.dans.bookreview.infra.adapters.dtos.ReviewDTO;
import dev.dans.bookreview.infra.adapters.mappers.ReviewMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ReviewDTO create(ReviewDTO reviewDTO) {
        Review review = ReviewMapper.toDomain(reviewDTO);
        review = createReviewUseCase.execute(review);
        return ReviewMapper.toJSON(review);
    }

    public List<ReviewDTO> findAll() {
        List<Review> reviews = findAllReviewsUseCase.execute();
        return reviews.stream()
                .map(ReviewMapper::toJSON)
                .collect(Collectors.toList());
    }

    public ReviewDTO findById(Long id) throws Exception {
        Review review = findReviewByIdUseCase.execute(id);
        return ReviewMapper.toJSON(review);
    }

    public ReviewDTO update(ReviewDTO reviewDTO) throws Exception {
        Review review = ReviewMapper.toDomain(reviewDTO);
        findReviewByIdUseCase.execute(review.getId());
        review = updateReviewUseCase.execute(review);
        return ReviewMapper.toJSON(review);
    }

    public void delete(Long id) throws Exception {
        findReviewByIdUseCase.execute(id);
        deleteReviewUseCase.execute(id);
    }
}
