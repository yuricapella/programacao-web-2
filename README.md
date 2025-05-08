# ML-Users - API de Gerenciamento de Usuários

## Descrição
API REST desenvolvida em Java com Spring Boot para gerenciamento de usuários, incluindo autenticação e autorização com Spring Security.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.4.4
- Spring Security
- Spring Data JPA
- H2 Database
- Swagger/OpenAPI
- Maven

## Configuração do Ambiente

### Pré-requisitos
- JDK 21
- Maven
- IDE de sua preferência (recomendado: IntelliJ IDEA ou Eclipse)

### Configurações do Banco de Dados
O projeto utiliza o H2 Database em memória com as seguintes configurações:
- URL: `jdbc:h2:mem:test`
- Username: `sa`
- Password: (vazio)
- Console H2: `http://localhost:8080/h2`

## Autenticação

### Usuários Iniciais
Ao iniciar a aplicação, 5 usuários são criados automaticamente:

1. João Silva
   - Email: joao.silva@email.com
   - Senha: senha123

2. Maria Oliveira
   - Email: maria.oliveira@email.com
   - Senha: senha456

3. Pedro Santos
   - Email: pedro.santos@email.com
   - Senha: senha789

4. Ana Rodrigues
   - Email: ana.rodrigues@email.com
   - Senha: senhaabc

5. Lucas Pereira
   - Email: lucas.pereira@email.com
   - Senha: senhaxyz

### Autenticação via Spring Security
A autenticação é realizada através do Spring Security, utilizando o `UserDetailsServiceImpl` que busca os usuários no banco de dados. As senhas são armazenadas com criptografia BCrypt.

## Endpoints da API

### Usuários
- `GET /usuarios` - Lista todos os usuários
- `GET /usuarios/{id}` - Busca usuário por ID
- `POST /usuarios` - Cria novo usuário
- `PUT /usuarios/{id}` - Atualiza usuário existente
- `DELETE /usuarios/{id}` - Remove usuário

### Documentação da API
- Swagger UI: `http://localhost:8080/swagger.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Estrutura do Projeto

### Modelos
- `Usuario`: Entidade principal com informações do usuário
- `Endereco`: Entidade relacionada ao endereço do usuário

### DTOs
- `UsuarioDTO`: DTO para transferência de dados do usuário
- `CriarUsuarioRequestDTO`: DTO para criação de usuário
- `AtualizarUsuarioRequestDTO`: DTO para atualização de usuário
- `EnderecoDTO`: DTO para transferência de dados do endereço

### Serviços
- `UserDetailsServiceImpl`: Implementação da autenticação
- `CriarUsuarioService`: Serviço para criação de usuários
- `BuscarUsuarioService`: Serviço para busca de usuários
- `AtualizarUsuarioService`: Serviço para atualização de usuários
- `DeletarUsuarioService`: Serviço para remoção de usuários
- `EnderecoService`: Serviço para integração com API ViaCEP

## Validações
- Nome: mínimo 3 caracteres
- Email: formato válido
- Senha: mínimo 3 caracteres
- Idade: valor positivo
- CEP: 8 dígitos

## Tratamento de Erros

O projeto implementa um tratamento de exceções personalizado para melhorar a experiência do usuário e manter a API padronizada:

#### Exceções Personalizadas
- `UsuarioNaoEncontradoException`  
  Lançada quando o usuário solicitado não é encontrado no banco de dados.

#### Erros Comuns Tratados
- `DataIntegrityViolationException`  
  Ocorre, por exemplo, quando há tentativa de cadastrar um e-mail já existente.
- Validações de campos obrigatórios ou com formato inválido.
- Falhas de autenticação (usuário não logado ou token inválido).

**Mais detalhes:** [Veja o arquivo de exceções](./EXCEPTIONS.md)

## Testes

A coleção do Postman inclui cenários de teste para:  
- Criação de usuário  
- Listagem de usuários  
- Atualização de usuário  
- Remoção de usuário  
- Casos de erro (campos inválidos, email duplicado, etc.)  

**Mais detalhes:** [Acesse a coleção Postman](https://github.com/yuricapella/programacao-web-2/tree/master/postman)  

## Executando o Projeto
1. Clone o repositório
2. Execute `mvn clean install`
3. Execute `mvn spring-boot:run`
4. Acesse `http://localhost:8080/swagger.html` para a documentação da API

## Segurança
- Autenticação via Spring Security
- Senhas criptografadas com BCrypt
- Validação de dados de entrada
- Tratamento de exceções
