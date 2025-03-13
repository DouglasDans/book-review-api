package dev.dans.bookreview.infra.adapters.mappers;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.infra.adapters.dtos.BookDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public static Book toDomain(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setTotalPages(bookDTO.getTotalPages());
        book.setLanguage(bookDTO.getLanguage());
        book.setDescription(bookDTO.getDescription());
        book.setIsbn(bookDTO.getIsbn());
        book.setEdition(bookDTO.getEdition());
        book.setPublicationDate(LocalDate.parse(bookDTO.getPublicationDate()));
        book.setAuthor(AuthorMapper.toDomain(bookDTO.getAuthor()));
        book.setCategory(CategoryMapper.toDomain(bookDTO.getCategory()));
        book.setPublisher(PublisherMapper.toDomain(bookDTO.getPublisher()));
        return book;
    }

    public static BookDTO toJSON(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setTotalPages(book.getTotalPages());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setPublicationDate(book.getPublicationDate().toString());
        bookDTO.setAuthor(AuthorMapper.toJSON(book.getAuthor()));
        bookDTO.setCategory(CategoryMapper.toJSON(book.getCategory()));
        bookDTO.setPublisher(PublisherMapper.toJSON(book.getPublisher()));
        return bookDTO;
    }
}
