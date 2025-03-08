package dev.dans.bookreview.application.usecases.book;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllBooksUseCase {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> execute() {
        return bookRepository.findAll();
    }
}
