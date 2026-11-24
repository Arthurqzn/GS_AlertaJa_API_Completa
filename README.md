# AlertaJá - API REST

Projeto desenvolvido para a Global Solution do curso de Sistemas de Informação da FIAP.

O AlertaJá tem como objetivo facilitar o registro e o acompanhamento de ocorrências urbanas, permitindo o cadastro de usuários, categorias, ocorrências e comentários.

A aplicação foi desenvolvida em Java com Spring Boot, utilizando SQL Server para armazenamento dos dados.

## Funcionalidades

- Cadastro e gerenciamento de usuários
- Cadastro de categorias
- Registro de ocorrências urbanas
- Consulta e atualização de ocorrências
- Comentários nas ocorrências
- Validação dos dados
- Tratamento de erros
- Documentação dos endpoints pelo Swagger
- Persistência dos dados no SQL Server

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- SQL Server
- Maven
- ModelMapper
- Bean Validation
- Swagger / OpenAPI
- Docker
- GitHub Actions
- Microsoft Azure

## Estrutura do projeto

- `controller` - Endpoints da API
- `service` - Regras de negócio
- `repository` - Comunicação com o banco de dados
- `entity` - Entidades do sistema
- `dto` - Transferência de dados
- `exception` - Tratamento de exceções
- `config` - Configurações da aplicação

## Entidades

O sistema possui quatro entidades principais:

| Entidade | Descrição |
|---|---|
| Usuário | Cadastro dos usuários do sistema |
| Categoria | Classificação das ocorrências |
| Ocorrência | Registro das situações urbanas |
| Comentário | Comentários relacionados às ocorrências |

As ocorrências possuem relacionamento com usuários e categorias. Os comentários estão relacionados aos usuários e às ocorrências.

## Como executar o projeto

### Pré-requisitos

- Java 17
- Maven
- Docker Desktop
- Git

### Executando com Docker

Clone o repositório:

```bash
git clone https://github.com/Arthurqzn/GS_AlertaJa_API_Completa.git
```

Acesse a pasta:

```bash
cd GS_AlertaJa_API_Completa
```

Crie o arquivo `.env` com base no `.env.example` e configure a senha do banco de dados.

Com o Docker Desktop aberto, execute:

```bash
docker compose up --build -d
```

Para verificar os containers:

```bash
docker ps
```

Caso a API inicie antes do banco de dados:

```bash
docker compose restart api
```

Após a inicialização, acesse:

http://localhost:8080/

Para encerrar a aplicação:

```bash
docker compose down
```

O ambiente Docker utiliza o banco `master` para execução local. Em produção, recomenda-se utilizar um banco exclusivo para a aplicação.

### Executando com Maven

Configure as variáveis de ambiente do banco:

- DB_URL
- DB_USER
- DB_PASSWORD

Execute:

```bash
mvn spring-boot:run
```

Para executar os testes:

```bash
mvn test
```

Para gerar o build:

```bash
mvn clean package
```

## Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /api/v1/usuarios | Listar usuários |
| GET | /api/v1/categorias | Listar categorias |
| GET | /api/v1/ocorrencias | Listar ocorrências |
| GET | /api/v1/comentarios | Listar comentários |

Todos os recursos possuem operações de cadastro, consulta, atualização e exclusão.

| Método | Operação |
|---|---|
| GET | Consultar |
| POST | Cadastrar |
| PUT | Atualizar |
| DELETE | Excluir |

Para cadastrar uma ocorrência, é necessário informar um usuário e uma categoria existentes.

## Swagger

A documentação da API permite visualizar e testar os endpoints diretamente pelo navegador.

Endereço local:

http://localhost:8080/

## Banco de dados

O banco utilizado no projeto é o Microsoft SQL Server, integrado à aplicação através do Spring Data JPA.

As informações de conexão são configuradas por variáveis de ambiente para evitar a exposição de credenciais no código.

## CI/CD

O projeto utiliza GitHub Actions para automatizar os testes, o build da aplicação e a publicação da imagem no Docker Hub.

As credenciais do Docker Hub devem ser configuradas nos Secrets do repositório:

- DOCKERHUB_USERNAME
- DOCKERHUB_TOKEN

O workflow é executado após um push na branch main.

## Deploy no Azure

A imagem Docker pode ser utilizada para implantação da API no Microsoft Azure.

Para o funcionamento da aplicação, é necessário configurar as variáveis de conexão com o SQL Server e disponibilizar a porta 8080.

## Links do projeto

- GitHub: https://github.com/Arthurqzn/GS_AlertaJa_API_Completa
- Docker Hub: INSERIR_LINK
- API no Azure: INSERIR_LINK

## Desenvolvedor

**Arthur Queiroz Nascimento**
**Gabriel de lima**
**Felipe Gasparetto Ohara Sato**
- RM: 555205,99659,554315
- Curso: Sistemas de Informação
- Turma: 3SIR
- Instituição: FIAP
- Global Solution - 2026

## Objetivo

O desenvolvimento do AlertaJá buscou aplicar os conhecimentos adquiridos durante o semestre, principalmente na construção de APIs REST, integração com banco de dados, utilização de containers e automação do processo de entrega da aplicação.
