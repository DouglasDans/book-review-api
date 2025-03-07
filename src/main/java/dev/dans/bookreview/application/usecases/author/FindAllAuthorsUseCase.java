package dev.dans.bookreview.application.usecases.author;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class FindAllAuthorsUseCase {
    private final AuthorRepository authorRepository;

    public FindAllAuthorsUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> execute() {
        return authorRepository.findAll();
    }
}
