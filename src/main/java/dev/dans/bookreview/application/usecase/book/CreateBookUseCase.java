package dev.dans.bookreview.application.usecase.book;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.repository.BookRepository;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBookUseCase {
    private final BookRepository bookRepository;

    public CreateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(Book book) {
        verifyNullAttributes(book);
        return bookRepository.save(book);
    }

    private void verifyNullAttributes(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new ResourceDataNullException("Title");
        }
        if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new ResourceDataNullException("Isbn");
        }
    }
}
