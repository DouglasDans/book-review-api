package dev.dans.bookreview.infra.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.domain.enums.UserRole;
import dev.dans.bookreview.infra.views.Views;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO {
    @JsonView(Views.ReviewRequest.class)
    private Long id;

    @JsonView(Views.UserRequest.class)
    private String name;

    @JsonView(Views.UserRequest.class)
    private String email;

    @JsonView(Views.UserRequest.class)
    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonView(Views.UserRequest.class)
    private UserRole role;
}
