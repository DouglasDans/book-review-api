package dev.dans.bookreview.infra.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.infra.views.Views;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookDTO {
    @JsonView(Views.ReviewRequest.class)
    private Long id;

    @JsonView(Views.BookRequest.class)
    private String title;

    @JsonView(Views.BookRequest.class)
    private int totalPages;

    @JsonView(Views.BookRequest.class)
    private String language;

    @JsonView(Views.BookRequest.class)
    private String description;

    @JsonView(Views.BookRequest.class)
    private String isbn;

    @JsonView(Views.BookRequest.class)
    private int edition;

    @JsonView(Views.BookRequest.class)
    private String publicationDate;

    @JsonView(Views.BookRequest.class)
    private AuthorDTO author;

    @JsonView(Views.BookRequest.class)
    private CategoryDTO category;

    @JsonView(Views.BookRequest.class)
    private PublisherDTO publisher;
}
