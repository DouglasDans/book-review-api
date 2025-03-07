### Book Reviews API
Aplicação backend completa feita para entrega no bootcamp de Spring da DIO.

### Regras de Negócio do Projeto
- Administradores podem cadastrar, atualizar, deletar e listar livros, autores, editoras e gêneros e criar reviews dos livros.
- Usuários comuns podem apenas ler livros, editoras, autores e gêneros e criar reviews dos livros.
- Para qualquer operação além da leitura, necessita de autenticação.
- Somente o Administrador pode ler ou alterar os usuários cadastrados.

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
