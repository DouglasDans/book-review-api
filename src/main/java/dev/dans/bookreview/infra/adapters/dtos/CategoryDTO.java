package dev.dans.bookreview.infra.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.infra.views.Views;
import lombok.Data;

@Data
public class CategoryDTO {
    @JsonView(Views.BookRequest.class)
    private Long id;

    @JsonView(Views.CategoryRequest.class)
    private String name;
}
