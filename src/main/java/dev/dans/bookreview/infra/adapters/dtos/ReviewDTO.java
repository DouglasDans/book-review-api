package dev.dans.bookreview.infra.adapters.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReviewDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String title;
    private float rating;
    private String comment;
    private UserDTO user;
    private BookDTO book;
}
