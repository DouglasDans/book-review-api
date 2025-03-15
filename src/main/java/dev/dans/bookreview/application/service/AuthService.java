package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.auth.LoginUseCase;
import dev.dans.bookreview.infra.adapters.dtos.LoginDTO;
import dev.dans.bookreview.infra.adapters.dtos.SessionDTO;
import dev.dans.bookreview.shared.exceptions.AuthenticationFailedException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final LoginUseCase loginUseCase;

    public AuthService(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public SessionDTO login(LoginDTO login) {
        try {
            return loginUseCase.execute(login);
        } catch (Exception e) {
            throw new AuthenticationFailedException("Failed to login, " + e.getMessage());
        }
    }
}
