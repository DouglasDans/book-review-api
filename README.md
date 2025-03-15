### Book Reviews API
Aplicação backend completa feita para entrega no bootcamp de Spring da DIO.

### Regras de Negócio do Projeto
- Administradores tem acesso total e podem cadastrar, atualizar, deletar e listar livros, autores, editoras, categorias, gêneros, e usuários.
- Usuários autenticados comuns podem apenas ler livros, editoras, categorias, autores, usuários e criar avaliações dos livros.
- Usuários não autenticados podem apenas ler livros, editoras, categorias, autores e avaliações.
- Somente o Administrador pode cadastrar, alterar e deletar os usuários cadastrados.

### Tecnologias Utilizadas
- Postgres(prod), H2 Database(dev)
- Spring Boot
- Spring Security
- Json Web Token
- Swagger

### Diagrama de classes UML
```mermaid
classDiagram
    class Book {
      +int id
      +string title
      +int totalPages
      +string language
      +string description
      +string isbn
      +int edition
      +Date publicationDate
    }
    
    class Publisher {
      +int id
      +string name
    }
    
    class Category {
      +int id
      +string name
    }
    
    class Author {
      +int id
      +string name
      +Date birthDate
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
    Book *-- "1.n" Category : categories
    Book *-- "1.n" Author : authors
    Book *-- "1.n" Review : reviews
    Review *-- "1.n" User : user
```
