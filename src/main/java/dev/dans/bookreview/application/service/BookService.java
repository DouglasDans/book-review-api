package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.book.*;
import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.entities.User;
import dev.dans.bookreview.domain.repository.BookRepository;
import dev.dans.bookreview.infra.adapters.dtos.BookDTO;
import dev.dans.bookreview.infra.adapters.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public BookDTO create(BookDTO bookDTO) {
        Book book = BookMapper.toDomain(bookDTO);
        book = createBookUseCase.execute(book);
        return BookMapper.toJSON(book);
    }

    public List<BookDTO> findAll() {
        List<Book> books = findAllBooksUseCase.execute();
        return books.stream()
                .map(BookMapper::toJSON)
                .collect(Collectors.toList());
    }

    public BookDTO findById(Long id) throws Exception {
        Book book = findBooksByIdUseCase.execute(id);
        return BookMapper.toJSON(book);
    }

    public BookDTO update(BookDTO bookDTO) throws Exception {
        Book book = BookMapper.toDomain(bookDTO);
        findBooksByIdUseCase.execute(book.getId());
        book = updateBookUseCase.execute(book);
        return BookMapper.toJSON(book);
    }

    public void delete(Long id) throws Exception {
        findBooksByIdUseCase.execute(id);
        deleteBookUseCase.execute(id);
    }
}
