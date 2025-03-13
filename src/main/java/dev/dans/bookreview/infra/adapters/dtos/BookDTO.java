package dev.dans.bookreview.infra.adapters.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String title;
    private int totalPages;
    private String language;
    private String description;
    private String isbn;
    private int edition;
    private String publicationDate;
    private AuthorDTO author;
    private CategoryDTO category;
    private PublisherDTO publisher;
}
