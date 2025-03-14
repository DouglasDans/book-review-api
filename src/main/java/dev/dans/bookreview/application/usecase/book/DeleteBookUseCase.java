package dev.dans.bookreview.application.usecase.book;

import dev.dans.bookreview.domain.repository.BookRepository;
import dev.dans.bookreview.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookUseCase {
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    public DeleteBookUseCase(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    public void execute(Long id) {
        reviewRepository.deleteAllByBookId(id);
        bookRepository.deleteById(id);
    }
}
