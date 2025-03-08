package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.user.*;
import dev.dans.bookreview.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User create(User user) {
        return createUserUseCase.execute(user);
    }

    public List<User> findAll() {
        return findAllUsersUseCase.execute();
    }

    public User findById(Long id) throws Exception {
        return findUserByIdUseCase.execute(id);
    }

    public User update(User user) throws Exception {
        findUserByIdUseCase.execute(user.getId());
        return updateUserUseCase.execute(user);
    }

    public void delete(Long id) throws Exception {
        findUserByIdUseCase.execute(id);
        deleteUserUseCase.execute(id);
    }
}