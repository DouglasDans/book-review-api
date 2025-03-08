package dev.dans.bookreview.application.usecases.book;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindBooksByIdUseCase {
    @Autowired
    public BookRepository bookRepository;

    public Book execute(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) throw new ResourceNotFoundException("Book ID:" + id + " not found");
        
        return book.get();
    }
}
