package dev.dans.bookreview.application.service;

import java.util.List;

import dev.dans.bookreview.application.usecase.author.*;
import dev.dans.bookreview.infra.adapters.dtos.AuthorDTO;
import dev.dans.bookreview.infra.adapters.mappers.AuthorMapper;
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

    public AuthorDTO create(AuthorDTO authorDTO){
        Author author = AuthorMapper.toDomain(authorDTO);
        author = this.createAuthorUseCase.execute(author);
        return AuthorMapper.toJSON(author);
    }

    public List<AuthorDTO> findAll(){
        List<Author> authors = this.findAllAuthorsUseCase.execute();
        return authors.stream()
                .map(AuthorMapper::toJSON)
                .collect(java.util.stream.Collectors.toList());
    }

    public AuthorDTO findById(Long id) throws Exception {
        Author author = this.findAuthorByIdUseCase.execute(id);
        return AuthorMapper.toJSON(author);
    }

    public AuthorDTO update(AuthorDTO authorDTO) throws Exception {
        Author author = AuthorMapper.toDomain(authorDTO);
        this.findAuthorByIdUseCase.execute(author.getId());
        author = this.updateAuthorUseCase.execute(author);
        return AuthorMapper.toJSON(author);
    }

    public void delete(Long id) throws Exception {
        this.findAuthorByIdUseCase.execute(id);
        this.deleteAuthorUseCase.execute(id);
    }
}
