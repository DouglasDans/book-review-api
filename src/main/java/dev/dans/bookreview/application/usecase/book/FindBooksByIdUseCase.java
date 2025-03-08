package dev.dans.bookreview.application.usecase.book;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindBooksByIdUseCase {
    private final BookRepository bookRepository;

    public FindBooksByIdUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) throw new ResourceNotFoundException("Book ID:" + id + " not found");

        return book.get();
    }
}
