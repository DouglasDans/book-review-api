package dev.dans.bookreview.application.usecases.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class FindAllAuthorsUseCase {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> execute() {
        return authorRepository.findAll();
    }
}
