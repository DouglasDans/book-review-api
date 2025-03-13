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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<RestResponse<List<ReviewDTO>>> getAllReviews() {
        List<ReviewDTO> reviews = reviewService.findAll();
        return RestResponseBuilder.build(
                reviews,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ReviewDTO>> getReview(@PathVariable Long id) throws Exception {
        ReviewDTO review = reviewService.findById(id);
        return RestResponseBuilder.build(
                review,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @PostMapping
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

    @PatchMapping
    public ResponseEntity<RestResponse<ReviewDTO>> updateReview(@RequestBody ReviewDTO review) throws Exception {
        ReviewDTO updatedReview = reviewService.update(review);
        return RestResponseBuilder.build(
                updatedReview,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
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
