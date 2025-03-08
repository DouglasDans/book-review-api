package dev.dans.bookreview.application.usecase.author;

import java.util.Optional;

import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.repository.AuthorRepository;

@Component
public class FindAuthorByIdUseCase {
    private final AuthorRepository authorRepository;

    public FindAuthorByIdUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author execute(Long id) {
        Optional<Author> author = this.authorRepository.findById(id);

        if(author.isEmpty()){
            throw new ResourceNotFoundException("User ID:" + id + " not found");
        }

        return author.get();
    }
}
