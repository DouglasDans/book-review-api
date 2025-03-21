package dev.dans.bookreview.infra.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.application.service.UserService;
import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.infra.adapters.dtos.UserDTO;
import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.infra.views.Views;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping
    @Transactional
    public ResponseEntity<RestResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userService.findAll();
        return RestResponseBuilder.build(
                users,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<UserDTO>> getUser(@PathVariable Long id) throws Exception {
        UserDTO user = userService.findById(id);
        return RestResponseBuilder.build(
                user,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<RestResponse<UserDTO>> createUser(
            @RequestBody @JsonView(Views.UserRequest.class) UserDTO userDTO
    ) {
        UserDTO createdUser = userService.create(userDTO);
        return RestResponseBuilder.build(
                createdUser,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.CREATED
        );
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<UserDTO>> updateUser(
            @PathVariable Long id,
            @RequestBody @JsonView(Views.UserRequest.class) UserDTO userDTO
    ) throws Exception {
        userDTO.setId(id);
        UserDTO updatedUser = userService.update(userDTO);
        return RestResponseBuilder.build(
                updatedUser,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<String>> deleteUser(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return RestResponseBuilder.build(
                "User deleted successfully",
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }
}
