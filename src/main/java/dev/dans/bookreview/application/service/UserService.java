package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecases.user.*;
import dev.dans.bookreview.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private CreateUserUseCase createUserUseCase;
    private FindAllUsersUseCase findAllUsersUseCase;
    private FindUserByIdUseCase findUserByIdUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;

    public User create(User user){
        return createUserUseCase.execute(user);
    }

    public List<User> findAll(){
        return findAllUsersUseCase.findAll();
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
