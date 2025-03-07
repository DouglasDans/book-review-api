package dev.dans.bookreview.application.service;

import java.util.List;

import dev.dans.bookreview.application.usecases.author.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dans.bookreview.domain.entities.Author;

@Service
public class AuthorService {
  @Autowired
  private CreateAuthorUseCase createAuthorUseCase;

  @Autowired
  private  FindAllAuthorsUseCase findAllAuthorsUseCase;

  @Autowired
  private  FindAuthorByIdUseCase findAuthorByIdUseCase;

  @Autowired
  private  UpdateAuthorUseCase updateAuthorUseCase;

  @Autowired
  private  DeleteAuthorUseCase deleteAuthorUseCase;

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
