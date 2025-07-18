# 📦 Gerenciador de Pedidos

Este projeto é um sistema simples de **gerenciamento de pedidos**, desenvolvido com **Spring Boot**, utilizando **JPA (Hibernate)** para persistência de dados em um banco **PostgreSQL**. Ele demonstra conceitos fundamentais como mapeamento objeto-relacional (ORM), criação de entidades, repositórios, e persistência de objetos na inicialização da aplicação.

---

## 📚 Sumário

- [🧪 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [⚙️ Estrutura do Projeto](#️-estrutura-do-projeto)
- [🗃️ Modelo de Dados](#️-modelo-de-dados)
- [🚀 Execução do Projeto](#-execução-do-projeto)
- [📌 Funcionalidades Demonstradas](#-funcionalidades-demonstradas)
- [📈 Possíveis Expansões](#-possíveis-expansões)

---

## 🧪 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Jakarta Persistence API

---

## ⚙️ Estrutura do Projeto

```
com.desafio.gerenciador_pedidos
│
├── model
│   ├── Produto.java
│   ├── Categoria.java
│   └── Pedido.java
│
├── repository
│   ├── ProdutoRepository.java
│   ├── CategoriaRepository.java
│   └── PedidoRepository.java
│
├── GerenciadorPedidosApplication.java
└── application.properties
```


---

## 🗃️ Modelo de Dados

### 🔹 Produto

| Campo   | Tipo     | Restrições       |
|---------|----------|------------------|
| id      | Long     | PK, auto-gerado  |
| nome    | String   | Não nulo, único  |
| preco   | double   | Não nulo         |

### 🔹 Categoria

| Campo   | Tipo     | Restrições       |
|---------|----------|------------------|
| id      | Long     | PK, auto-gerado  |
| nome    | String   | Não nulo         |

### 🔹 Pedido

| Campo   | Tipo       | Restrições       |
|---------|------------|------------------|
| id      | Long       | PK, auto-gerado  |
| data    | LocalDate  | Não nulo         |

---

# 📌 Funcionalidades Demonstradas
- Criação de entidades com JPA (@Entity, @Table, @Id, @GeneratedValue)

- Persistência de objetos via repositórios (JpaRepository)

- Injeção de dependência com @Autowired

- Execução de código ao iniciar a aplicação com CommandLineRunner

- Separação de camadas: Modelos, Repositórios e Lógica de Inicialização

- Conexão e integração com banco de dados relacional (PostgreSQL)

# 📈 Possíveis Expansões
- Relacionamentos entre entidades (@ManyToOne, @OneToMany)

- Camada de serviço com regras de negócio

- API REST usando @RestController e @RequestMapping

- Validações com Bean Validation (@NotNull, @Size, etc.)

- Integração com frontend ou testes automatizados (JUnit, Mockito)
