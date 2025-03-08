package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.book.*;
import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final CreateBookUseCase createBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final FindAllBooksUseCase findAllBooksUseCase;
    private final FindBooksByIdUseCase findBooksByIdUseCase;
    private final UpdateBookUseCase updateBookUseCase;

    public BookService(CreateBookUseCase createBookUseCase,
                       DeleteBookUseCase deleteBookUseCase,
                       FindAllBooksUseCase findAllBooksUseCase,
                       FindBooksByIdUseCase findBooksByIdUseCase,
                       UpdateBookUseCase updateBookUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.findAllBooksUseCase = findAllBooksUseCase;
        this.findBooksByIdUseCase = findBooksByIdUseCase;
        this.updateBookUseCase = updateBookUseCase;
    }

    public Book create(Book book) {
        return createBookUseCase.execute(book);
    }

    public List<Book> findAll() {
        return findAllBooksUseCase.execute();
    }

    public Book findById(Long id) throws Exception {
        return findBooksByIdUseCase.execute(id);
    }

    public Book update(Book book) throws Exception {
        findBooksByIdUseCase.execute(book.getId());
        return updateBookUseCase.execute(book);
    }

    public void delete(Long id) throws Exception {
        findBooksByIdUseCase.execute(id);
        deleteBookUseCase.execute(id);
    }
}
