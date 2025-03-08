package dev.dans.bookreview.application.usecases.book;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateBookUseCase {
    @Autowired
    private BookRepository bookRepository;

    public Book execute(Book book) {
        return bookRepository.save(book);
    }
}
