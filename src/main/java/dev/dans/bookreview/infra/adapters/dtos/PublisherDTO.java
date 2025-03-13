package dev.dans.bookreview.infra.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.infra.views.Views;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PublisherDTO {
    @JsonView(Views.BookRequest.class)
    private Long id;

    @JsonView(Views.PublisherRequest.class)
    private String name;
}
