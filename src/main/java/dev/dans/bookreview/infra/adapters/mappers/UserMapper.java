package dev.dans.bookreview.infra.adapters.mappers;

import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.infra.adapters.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User toDomain(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public static UserDTO toJSON(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
