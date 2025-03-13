package dev.dans.bookreview.infra.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.infra.views.Views;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReviewDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @JsonView(Views.ReviewRequest.class)
    private String title;

    @JsonView(Views.ReviewRequest.class)
    private float rating;

    @JsonView(Views.ReviewRequest.class)
    private String comment;

    @JsonView(Views.ReviewRequest.class)
    private UserDTO user;

    @JsonView(Views.ReviewRequest.class)
    private BookDTO book;
}
