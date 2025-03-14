package dev.dans.bookreview.infra.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.application.service.BookService;
import dev.dans.bookreview.infra.adapters.dtos.BookDTO;
import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.infra.views.Views;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @CrossOrigin
    @GetMapping
    @Transactional
    public ResponseEntity<RestResponse<List<BookDTO>>> getAllBooks() {
        List<BookDTO> books = bookService.findAll();
        return RestResponseBuilder.build(
                books,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<BookDTO>> getBook(@PathVariable Long id) throws Exception {
        BookDTO book = bookService.findById(id);
        return RestResponseBuilder.build(
                book,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<RestResponse<BookDTO>> createBook(
            @RequestBody @JsonView(Views.BookRequest.class) BookDTO book
    ) {
        BookDTO createdBook = bookService.create(book);
        return RestResponseBuilder.build(
                createdBook,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.CREATED
        );
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<BookDTO>> updateBook(
            @PathVariable Long id,
            @RequestBody @JsonView(Views.BookRequest.class) BookDTO book
    ) throws Exception {
        book.setId(id);
        BookDTO updatedBook = bookService.update(book);
        return RestResponseBuilder.build(
                updatedBook,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<String>> deleteBook(@PathVariable Long id) throws Exception {
        bookService.delete(id);
        return RestResponseBuilder.build(
                "Book deleted successfully",
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }
}
