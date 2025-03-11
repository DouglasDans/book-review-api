package dev.dans.bookreview.infra.adapters.mappers;

import dev.dans.bookreview.domain.entities.Review;
import dev.dans.bookreview.infra.adapters.dtos.ReviewDTO;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public static Review toDomain(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setUser(UserMapper.toDomain(reviewDTO.getUser()));
        review.setBook(BookMapper.toDomain(reviewDTO.getBook()));
        return review;
    }

    public static ReviewDTO toJSON(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setUser(UserMapper.toJSON(review.getUser()));
        reviewDTO.setBook(BookMapper.toJSON(review.getBook()));
        return reviewDTO;
    }
}
