package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.user.*;
import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.infra.adapters.dtos.UserDTO;
import dev.dans.bookreview.infra.adapters.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final CreateUserUseCase createUserUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase,
                       FindAllUsersUseCase findAllUsersUseCase,
                       FindUserByIdUseCase findUserByIdUseCase,
                       UpdateUserUseCase updateUserUseCase,
                       DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    public UserDTO create(UserDTO userDTO) {
        User user = UserMapper.toDomain(userDTO);
        user = createUserUseCase.execute(user);
        return UserMapper.toJSON(user);
    }

    public List<UserDTO> findAll() {
        List<User> users = findAllUsersUseCase.execute();
        return users.stream()
                .map(UserMapper::toJSON)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) throws Exception {
        return UserMapper.toJSON(findUserByIdUseCase.execute(id));
    }

    public UserDTO update(UserDTO userDTO) throws Exception {
        User user = UserMapper.toDomain(userDTO);
        findUserByIdUseCase.execute(user.getId());
        user = updateUserUseCase.execute(user);
        return UserMapper.toJSON(user);
    }

    public void delete(Long id) throws Exception {
        findUserByIdUseCase.execute(id);
        deleteUserUseCase.execute(id);
    }
}