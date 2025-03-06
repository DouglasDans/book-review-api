### Book Reviews API
Aplicação backend completa feita para entrega no bootcamp de Spring da DIO

### Tecnologias Utilizadas
- Docker
- Postgres
- Spring Boot
- Spring Security
- Json Web Token
- Swagger

### Diagrama de classes UML
```mermaid
classDiagram
    class Book {
      +int id
      +string nome
      +int totalPages
      +string language
      +string description
      +string isbn
      +int edition
      +string publicationDate
    }
    
    class Publisher {
      +int id
      +string name
    }
    
    class Genre {
      +int id
      +string name
    }
    
    class Author {
      +int id
      +string name
      +string birthDate
      +string nationality
      +string biography
    }
    
    class Review {
      +int id
      +string titulo
      +float rating
      +string comment
    }
    
    class User {
      +int id
      +string name
      +string email
      +string password
      +List~string~ roles
    }
    
    Book *-- "1.1" Publisher : publisher
    Book *-- "1.n" Genre : genres
    Book *-- "1.n" Author : authors
    Book *-- "1.n" Review : reviews
    Review *-- "1.n" User : user
```
