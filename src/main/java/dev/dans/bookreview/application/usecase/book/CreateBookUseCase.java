package dev.dans.bookreview.application.usecase.book;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBookUseCase {
    private final BookRepository bookRepository;

    public CreateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(Book book) {
        return bookRepository.save(book);
    }
}
