package dev.dans.bookreview.infra.config;

import dev.dans.bookreview.application.service.UserService;
import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.enums.UserRole;
import dev.dans.bookreview.domain.repository.*;
import dev.dans.bookreview.infra.adapters.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private UserService userService;

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            try{
                UserDTO user = userService.findById(1L);

                if (user == null || user.getEmail().equals("admin@admin.com")) {
                    return;
                }
            } catch (Exception e){
                logger.info("Preloading initial data");

            }

            UserDTO userDTO = new UserDTO();
            userDTO.setName("Admin");
            userDTO.setEmail("admin@admin.com");
            userDTO.setPassword("admin");
            userDTO.setRole(UserRole.ROLE_ADMIN);
            userService.create(userDTO);

            logger.info("Preloaded {} users", userRepository.count());
        };
    }
}
