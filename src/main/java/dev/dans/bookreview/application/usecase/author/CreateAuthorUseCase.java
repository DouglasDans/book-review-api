package dev.dans.bookreview.application.usecase.author;

import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class CreateAuthorUseCase {
    private final AuthorRepository authorRepository;

    public CreateAuthorUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author execute(Author author) {
        verifyNullAttributes(author);
        return authorRepository.save(author);
    }

    private void verifyNullAttributes(Author author) {
        if (author.getName() == null || author.getName().isEmpty()) {
            throw new ResourceDataNullException("Author name");
        }
    }
}