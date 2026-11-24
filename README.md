# AlertaJá — API REST | Global Solution 3SIR

API de gerenciamento de ocorrências urbanas desenvolvida em Java 17 e Spring Boot 3, com persistência em SQL Server. As quatro entidades são **Usuário**, **Categoria**, **Ocorrência** e **Comentário**, com relacionamentos entre ocorrências, usuários e categorias e entre comentários, usuários e ocorrências.

## Tecnologias
Java 17, Spring Boot, Spring Data JPA, Bean Validation, ModelMapper, Microsoft SQL Server, Swagger/OpenAPI, Maven, Docker e GitHub Actions.

## Como executar (Docker)
1. Instale Docker Desktop e inicie o Docker Engine.
2. Copie `.env.example` para `.env` e substitua a senha por uma senha forte (mínimo 8 caracteres com maiúscula, minúscula, número e símbolo).
3. Execute `docker compose up --build -d` na raiz do projeto.
4. Aguarde o SQL Server inicializar (na primeira execução pode levar alguns minutos). Se a API iniciar antes do banco, execute `docker compose restart api`.
5. Abra `http://localhost:8080/` para o Swagger. Para desligar, use `docker compose down`.

O compose usa o banco `master` para simplificar a primeira execução local. Para produção, crie um banco exclusivo `alertaja` e configure `DB_URL` para ele. Não use a senha de exemplo em produção.

## Como executar com Maven
Inicie o SQL Server e configure `DB_URL`, `DB_USER` e `DB_PASSWORD` no ambiente. Execute `mvn spring-boot:run`. Para testes: `mvn test`. Para empacotar: `mvn clean package`.

## Endpoints
Todos os recursos suportam:

| Método | Rota | Ação |
|---|---|---|
| GET | `/api/v1/{recurso}` | Listar |
| GET | `/api/v1/{recurso}/{id}` | Consultar |
| POST | `/api/v1/{recurso}` | Criar (201) |
| PUT | `/api/v1/{recurso}/{id}` | Atualizar (200) |
| DELETE | `/api/v1/{recurso}/{id}` | Excluir (204) |

Substitua `{recurso}` por `usuarios`, `categorias`, `ocorrencias` ou `comentarios`. Os retornos de erro incluem 400 para entrada inválida e 404 para recurso inexistente. O Swagger mostra os DTOs e permite testar as rotas.

### Exemplo de criação
```bash
curl -X POST http://localhost:8080/api/v1/usuarios -H 'Content-Type: application/json' -d '{"nome":"Ana","email":"ana@exemplo.com","telefone":"11999999999","bairro":"Centro","ativo":true}'
```

Para criar uma ocorrência, primeiro cadastre um usuário e uma categoria, depois informe `usuarioId` e `categoriaId` no corpo da requisição. Para comentários, cadastre uma ocorrência e informe `ocorrenciaId` e `usuarioId`.

## GitHub Actions e Docker Hub
No GitHub, configure os Secrets `DOCKERHUB_USERNAME` e `DOCKERHUB_TOKEN` (token de acesso do Docker Hub). Ao fazer push para `main`, o workflow executa testes, constrói a imagem e publica `usuario/alertaja-api:latest` e uma tag com o SHA do commit. Confirme o resultado na aba **Actions**. Não publique credenciais no repositório.

## Implantação no Azure
Crie um Azure Container App ou App Service for Containers apontando para a imagem publicada no Docker Hub. Configure as variáveis `DB_URL`, `DB_USER` e `DB_PASSWORD` com as credenciais de um SQL Server acessível pelo serviço Azure. Exponha a porta 8080 e valide `https://SUA-URL/` e os endpoints. O deploy no Azure não acontece automaticamente neste projeto; ele precisa ser realizado na sua conta.

## Evidências para entrega
Adicione à entrega os links reais do repositório GitHub, Docker Hub e API no Azure. Salve prints da execução bem-sucedida do GitHub Actions, da imagem no Docker Hub, do Swagger e da persistência no SQL Server. O PDF do professor exige um TXT com nomes/RMs e os três links.

## Estrutura
`controller/` (rotas), `service/` (regras), `repository/` (JPA), `entity/` (modelos), `dto/` (entrada e saída), `exception/` (erros), `config/` (mapeamento).
