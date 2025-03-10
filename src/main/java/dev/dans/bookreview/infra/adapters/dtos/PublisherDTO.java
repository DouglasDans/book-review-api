package dev.dans.bookreview.infra.adapters.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PublisherDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String name;
}
