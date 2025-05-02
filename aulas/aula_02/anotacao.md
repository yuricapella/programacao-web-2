# Aula 2: API REST com Spring Boot

---

### application.properties  
- Arquivo de configuração do banco de dados (URL, usuário, senha, dialect).

---

### Endpoint para usuários  
```http
GET http://localhost:8080/usuarios
```  
→ Retorna lista de usuários.

---

### Beans e Inversão de Controle (IoC)
- Spring instancia automaticamente classes anotadas como Beans.
- Anotações:
    - `@RestController` (controllers)
    - `@Service` (serviços)
    - `@Component` (componentes genéricos)
    - `@Repository` (repositórios)
- Injeção de dependência:
  ```java
  @Autowired
  private BuscarUsuarioService buscarUsuarioService;
  ```
  é equivalente a:
  ```java
  private final BuscarUsuarioService buscarUsuarioService;

  public UsuarioController(BuscarUsuarioService buscarUsuarioService) {
      this.buscarUsuarioService = buscarUsuarioService;
  }
  ```

---

### pom.xml (Maven POM)
- XML que define:
    - dependências
    - plugins
    - informações do projeto (nome, versão, descrição, URL)
    - ciclo de build
- Fundamental para projetos Maven.

---

### Bibliotecas comuns (via Spring Initializr)
- H2 Database
- Spring Data JPA
- Jackson (serialização JSON; exige getters/setters)
- Bean Validation (JSR-380)

---

### DTO
- Filtra e modela os dados expostos pela API, isolando a camada de persistência da representação externa.