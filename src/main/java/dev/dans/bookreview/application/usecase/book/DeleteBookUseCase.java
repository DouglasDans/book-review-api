package dev.dans.bookreview.application.usecase.book;

import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookUseCase {
    private final BookRepository bookRepository;

    public DeleteBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Long id) {
        bookRepository.deleteById(id);
    }
}
