package dev.dans.bookreview.infra.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.application.service.AuthorService;
import dev.dans.bookreview.infra.adapters.dtos.AuthorDTO;
import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.infra.views.Views;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @CrossOrigin
    @GetMapping
    @Transactional
    public ResponseEntity<RestResponse<List<AuthorDTO>>> getAuthors() {
        List<AuthorDTO> authors = authorService.findAll();
        return RestResponseBuilder.build(
                authors,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<AuthorDTO>> getAuthor(@PathVariable Long id) throws Exception {
        AuthorDTO author = authorService.findById(id);
        return RestResponseBuilder.build(
                author,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<RestResponse<AuthorDTO>> createAuthor(
            @RequestBody @JsonView(Views.AuthorRequest.class) AuthorDTO author
    ) {
        AuthorDTO createdAuthor = authorService.create(author);
        return RestResponseBuilder.build(
                createdAuthor,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.CREATED
        );
    }

    @CrossOrigin
    @PatchMapping
    @Transactional
    public ResponseEntity<RestResponse<AuthorDTO>> updateAuthor(AuthorDTO author) throws Exception {
        AuthorDTO updatedAuthor = authorService.update(author);
        return RestResponseBuilder.build(
                updatedAuthor,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<String>> deleteAuthor(@PathVariable Long id) throws Exception {
        authorService.delete(id);
        return RestResponseBuilder.build(
                "Author deleted successfully",
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }
}
