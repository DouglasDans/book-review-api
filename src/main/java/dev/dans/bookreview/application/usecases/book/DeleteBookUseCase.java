package dev.dans.bookreview.application.usecases.book;

import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookUseCase {
    @Autowired
    private BookRepository bookRepository;

    public void execute(Long id) {
        bookRepository.deleteById(id);
    }
}
