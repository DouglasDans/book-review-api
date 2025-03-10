package dev.dans.bookreview.infra.adapters.dtos;

import lombok.Data;

@Data
public class SessionDTO {
    private String login;
    private String token;
}
