package dev.dans.bookreview.application.usecase.author;

import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class UpdateAuthorUseCase {
    private final AuthorRepository authorRepository;

    public UpdateAuthorUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author execute(Author author) {
        return authorRepository.save(author);
    }
}
