package dev.dans.bookreview.application.service;

import java.util.List;

import dev.dans.bookreview.application.usecase.author.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dans.bookreview.domain.entities.Author;

@Service
public class AuthorService {
    private final CreateAuthorUseCase createAuthorUseCase;
    private final FindAllAuthorsUseCase findAllAuthorsUseCase;
    private final FindAuthorByIdUseCase findAuthorByIdUseCase;
    private final UpdateAuthorUseCase updateAuthorUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;

    public AuthorService(CreateAuthorUseCase createAuthorUseCase,
                         FindAllAuthorsUseCase findAllAuthorsUseCase,
                         FindAuthorByIdUseCase findAuthorByIdUseCase,
                         UpdateAuthorUseCase updateAuthorUseCase,
                         DeleteAuthorUseCase deleteAuthorUseCase) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.findAllAuthorsUseCase = findAllAuthorsUseCase;
        this.findAuthorByIdUseCase = findAuthorByIdUseCase;
        this.updateAuthorUseCase = updateAuthorUseCase;
        this.deleteAuthorUseCase = deleteAuthorUseCase;
    }

    public Author create(Author author){
        return this.createAuthorUseCase.execute(author);
    }

    public List<Author> findAll(){
        return this.findAllAuthorsUseCase.execute();
    }

    public Author findById(Long id) throws Exception {
        return this.findAuthorByIdUseCase.execute(id);
    }

    public Author update(Author author) throws Exception {
        this.findAuthorByIdUseCase.execute(author.getId());
        return this.updateAuthorUseCase.execute(author);
    }

    public void delete(Long id) throws Exception {
        this.findAuthorByIdUseCase.execute(id);
        this.deleteAuthorUseCase.execute(id);
    }
}
