package dev.dans.bookreview.infra.adapters.mappers;

import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.infra.adapters.dtos.AuthorDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AuthorMapper {
    public static Author toDomain(AuthorDTO authorDTO){
        if(authorDTO == null) return null;

        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setBirthDate(authorDTO.getBirthDate() != null ? LocalDate.parse(authorDTO.getBirthDate()) : null);
        author.setNationality(authorDTO.getNationality());
        author.setBiography(authorDTO.getBiography());
        return author;
    }

    public static AuthorDTO toJSON(Author author){
        if(author == null) return null;

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBirthDate(author.getBirthDate() != null ? author.getBirthDate().toString() : null);
        authorDTO.setNationality(author.getNationality());
        authorDTO.setBiography(author.getBiography());
        return authorDTO;
    }
}
