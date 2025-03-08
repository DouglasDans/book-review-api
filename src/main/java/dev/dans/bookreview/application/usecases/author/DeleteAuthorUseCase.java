package dev.dans.bookreview.application.usecases.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class DeleteAuthorUseCase {
    @Autowired
    private AuthorRepository authorRepository;

    public void execute(Long id) {
        authorRepository.deleteById(id);
    }
}
