# 🎓 API de Gerenciamento de Alunos e Cursos

Este projeto é uma API REST desenvolvida com **Spring Boot**, que permite o gerenciamento de duas entidades: `Aluno` e `Curso`. A aplicação implementa operações CRUD completas e persiste os dados em um banco de dados MariaDB.

## 📌 Funcionalidades

- Cadastro, consulta, atualização e remoção de **alunos**
- Cadastro, consulta, atualização e remoção de **cursos**
- Relacionamento `ManyToOne`: um curso pode ter vários alunos

## 🧩 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- MariaDB
- Maven

## 📁 Estrutura do Projeto

src ├── controller │ ├── AlunoController.java │ └── CursoController.java ├── model │ ├── Aluno.java │ └── Curso.java ├── repository │ ├── AlunoRepository.java │ └── CursoRepository.java ├── service │ ├── AlunoService.java │ └── CursoService.java └── DemoApplication.java

bash
Copiar
Editar

## 🔄 Endpoints

### Alunos

| Método | Endpoint         | Descrição                      |
|--------|------------------|-------------------------------|
| GET    | `/alunos`        | Lista todos os alunos         |
| GET    | `/alunos/{id}`   | Retorna um aluno por ID       |
| POST   | `/alunos`        | Cadastra um novo aluno        |
| PUT    | `/alunos/{id}`   | Atualiza um aluno existente   |
| DELETE | `/alunos/{id}`   | Remove um aluno               |

### Cursos

| Método | Endpoint         | Descrição                      |
|--------|------------------|-------------------------------|
| GET    | `/cursos`        | Lista todos os cursos         |
| GET    | `/cursos/{id}`   | Retorna um curso por ID       |
| POST   | `/cursos`        | Cadastra um novo curso        |
| PUT    | `/cursos/{id}`   | Atualiza um curso existente   |
| DELETE | `/cursos/{id}`   | Remove um curso               |

## ⚙️ Configuração

1. Crie um banco de dados MariaDB chamado `escola`
2. Configure o arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/escola
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Rode o projeto com sua IDE ou via terminal:

bash
Copiar
Editar
./mvnw spring-boot:run

🧪 Testes
Utilize ferramentas como Postman, Insomnia ou cURL para testar os endpoints da API.

✍️ Observações
Lombok é utilizado para reduzir a verbosidade nas entidades.

As atualizações e exclusões utilizam Optional e ResponseEntity para controle de retorno HTTP.

O projeto é focado em funcionalidade e clareza de código, sem camadas de DTO ou tratamento global de exceções.

👨‍💻 Autor
Desenvolvido por Lucas Rodrigues Dias Nascimento para fins acadêmicos na matéria de Arquitetura de Aplicações Web.
