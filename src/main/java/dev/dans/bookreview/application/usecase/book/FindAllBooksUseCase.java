package dev.dans.bookreview.application.usecase.book;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllBooksUseCase {
    private final BookRepository bookRepository;

    public FindAllBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute() {
        return bookRepository.findAll();
    }
}
