package dev.dans.bookreview.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "total_pages")
    private int totalPages;

    @Column(name = "language")
    private String language;

    @Column(name = "description")
    private String description;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "edition")
    private int edition;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Author> author;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Category> category;

    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
