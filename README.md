# CulturaHub - API REST para Gestão de Eventos Culturais

## Sobre o Projeto

O **CulturaHub** é uma API REST desenvolvida em **Java** utilizando o framework **Spring Boot**, criada como trabalho final da disciplina de Modelagem e Arquitetura de Sistemas.

O sistema tem como objetivo gerenciar eventos culturais por meio de operações de cadastro, consulta, atualização e exclusão (CRUD), além de disponibilizar funcionalidades específicas para cada entidade do sistema.

A arquitetura utilizada é a **REST API**, organizada em camadas para facilitar a manutenção, organização do código e reutilização de componentes.

---

## Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* Jakarta Persistence (JPA)
* Postman (para testes da API)

---

## Arquitetura do Projeto

O projeto foi desenvolvido seguindo o padrão de arquitetura REST, organizado nas seguintes camadas:

```
src
└── main
    ├── java
    │   └── com.culturahub
    │       ├── controller
    │       ├── dto
    │       ├── entities
    │       ├── repository
    │       ├── service
    │       └── CulturaHubApplication
    └── resources
        └── application.properties
```

Cada camada possui uma responsabilidade específica:

* **Controller:** recebe as requisições HTTP.
* **Service:** contém as regras de negócio da aplicação.
* **Repository:** realiza o acesso ao banco de dados através do Spring Data JPA.
* **Entities:** representam as tabelas do banco de dados.
* **DTO:** realiza a transferência de dados entre a API e o cliente.

---

## Funcionalidades

O sistema possui cinco entidades principais:

* Evento
* Artista
* Local
* Ingresso
* Categoria

Para cada entidade foram implementadas as seguintes operações:

* Cadastro
* Listagem
* Busca por ID
* Atualização
* Exclusão

Além disso, cada entidade possui uma funcionalidade adicional:

| Entidade  | Funcionalidade  |
| --------- | --------------- |
| Evento    | Encerrar evento |
| Artista   | Atualizar cachê |
| Local     | Bloquear local  |
| Ingresso  | Encerrar venda  |
| Categoria | Alterar status  |

---

## Endpoints

Cada entidade possui os seguintes endpoints:

### Evento

| Método | Endpoint              |
| ------ | --------------------- |
| POST   | /evento/cadastro      |
| GET    | /evento/lista         |
| GET    | /evento/buscar/{id}   |
| PUT    | /evento/editar/{id}   |
| DELETE | /evento/excluir/{id}  |
| PUT    | /evento/encerrar/{id} |

### Artista

| Método | Endpoint                      |
| ------ | ----------------------------- |
| POST   | /artista/cadastro             |
| GET    | /artista/lista                |
| GET    | /artista/buscar/{id}          |
| PUT    | /artista/editar/{id}          |
| DELETE | /artista/excluir/{id}         |
| PUT    | /artista/atualizar-cache/{id} |

### Local

| Método | Endpoint             |
| ------ | -------------------- |
| POST   | /local/cadastro      |
| GET    | /local/lista         |
| GET    | /local/buscar/{id}   |
| PUT    | /local/editar/{id}   |
| DELETE | /local/excluir/{id}  |
| PUT    | /local/bloquear/{id} |

### Ingresso

| Método | Endpoint                      |
| ------ | ----------------------------- |
| POST   | /ingresso/cadastro            |
| GET    | /ingresso/lista               |
| GET    | /ingresso/buscar/{id}         |
| PUT    | /ingresso/editar/{id}         |
| DELETE | /ingresso/excluir/{id}        |
| PUT    | /ingresso/encerrar-venda/{id} |

### Categoria

| Método | Endpoint                       |
| ------ | ------------------------------ |
| POST   | /categoria/cadastro            |
| GET    | /categoria/lista               |
| GET    | /categoria/buscar/{id}         |
| PUT    | /categoria/editar/{id}         |
| DELETE | /categoria/excluir/{id}        |
| PUT    | /categoria/alterar-status/{id} |

---

# Como executar o projeto localmente

## 1. Clonar o repositório

```bash
git clone https://github.com/ADS-graduacao/ADS-Arq.Projeto-Final.git
```

ou faça o download do projeto em formato ZIP e extraia os arquivos.

---

## 2. Criar o banco de dados

Abra o PostgreSQL e crie um banco de dados.

---

## 3. Configurar o application.properties

Configure as credenciais do banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/senai
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

Caso utilize outra porta, usuário ou senha, altere as configurações conforme necessário.

---

## 4. Executar o projeto

Abra o projeto em uma IDE compatível (IntelliJ IDEA, Eclipse ou VS Code).

Execute a classe principal:

```
TrabalhoFinalApplication.java
```

ou execute pelo Maven:

```bash
mvn spring-boot:run
```

---

## 5. Acessar a API

Após iniciar a aplicação, a API estará disponível em:

```
http://localhost:8080
```

---

## Testes

Os endpoints podem ser testados utilizando:

* Postman
* Insomnia

Para requisições POST e PUT, utilize o cabeçalho:

```
Content-Type: application/json
```

---

## Estrutura da API

A aplicação foi desenvolvida seguindo o padrão em camadas:

```
Controller
        ↓
Service
        ↓
Repository
        ↓
Banco de Dados PostgreSQL
```

---

## Autor

Projeto desenvolvido como Trabalho Final da disciplina de Modelagem e Arquitetura de Sistemas.

Curso: Análise e Desenvolvimento de Sistemas

Instituição: UniSENAI
