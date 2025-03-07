package dev.dans.bookreview.application.usecases.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class CreateAuthorUseCase {
    @Autowired
    private AuthorRepository authorRepository;

    public Author execute(Author author) {
        return authorRepository.save(author);
    }
}
