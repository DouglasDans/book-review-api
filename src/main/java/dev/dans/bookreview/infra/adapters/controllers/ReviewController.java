package dev.dans.bookreview.infra.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.application.service.ReviewService;
import dev.dans.bookreview.infra.adapters.dtos.ReviewDTO;
import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.infra.views.Views;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @CrossOrigin
    @GetMapping
    @Transactional
    public ResponseEntity<RestResponse<List<ReviewDTO>>> getAllReviews() {
        List<ReviewDTO> reviews = reviewService.findAll();
        return RestResponseBuilder.build(
                reviews,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<ReviewDTO>> getReview(@PathVariable Long id) throws Exception {
        ReviewDTO review = reviewService.findById(id);
        return RestResponseBuilder.build(
                review,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<RestResponse<ReviewDTO>> createReview(
            @RequestBody @JsonView(Views.ReviewRequest.class) ReviewDTO review
    ) {
        ReviewDTO createdReview = reviewService.create(review);
        return RestResponseBuilder.build(
                createdReview,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.CREATED
        );
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<ReviewDTO>> updateReview(
            @PathVariable Long id,
            @RequestBody @JsonView(Views.ReviewRequest.class) ReviewDTO review
    ) throws Exception {
        review.setId(id);
        ReviewDTO updatedReview = reviewService.update(review);
        return RestResponseBuilder.build(
                updatedReview,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<String>> deleteReview(@PathVariable Long id) throws Exception {
        reviewService.delete(id);
        return RestResponseBuilder.build(
                "Review deleted successfully",
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }
}
