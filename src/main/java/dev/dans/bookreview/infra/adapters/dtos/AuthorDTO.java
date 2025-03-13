package dev.dans.bookreview.infra.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.infra.views.Views;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AuthorDTO {
    @JsonView(Views.BookRequest.class)
    private Long id;

    @JsonView(Views.AuthorRequest.class)
    private String name;

    @JsonView(Views.AuthorRequest.class)
    private String birthDate;

    @JsonView(Views.AuthorRequest.class)
    private String nationality;

    @JsonView(Views.AuthorRequest.class)
    private String biography;
}
