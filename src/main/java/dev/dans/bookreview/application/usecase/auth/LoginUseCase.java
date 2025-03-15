package dev.dans.bookreview.application.usecase.auth;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.UserRepository;
import dev.dans.bookreview.infra.adapters.dtos.LoginDTO;
import dev.dans.bookreview.infra.adapters.dtos.SessionDTO;
import dev.dans.bookreview.infra.security.JWTBuilder;
import dev.dans.bookreview.infra.security.JWTObject;
import dev.dans.bookreview.infra.security.SecurityConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class LoginUseCase {
    private final UserRepository userRepository;

    public LoginUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SessionDTO execute(LoginDTO login){
        User user = userRepository.findUserByEmail(login.getEmail());

        if (!new BCryptPasswordEncoder().matches(login.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        SessionDTO session = new SessionDTO();
        session.setLogin(user.getEmail());

        JWTObject jwt = new JWTObject();
        jwt.setIssuedAt(new Date(System.currentTimeMillis()));
        jwt.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
        jwt.setRoles(user.getRole().name());
        session.setToken(JWTBuilder.build(SecurityConfig.PREFIX, SecurityConfig.KEY, jwt));
        return session;
    }
}
