# Aula 3: DTO e Validações

## Geração de Identificador  
- Estratégia trocada de `AUTO` para `IDENTITY` (no `@GeneratedValue(strategy = GenerationType.IDENTITY)`), delegando ao banco a geração de IDs.

---

## DTO (Data Transfer Object)  
- Padrão: nome do arquivo termina em `RequestDTO` para classes que representam entrada de dados.  
- No controller, receba sempre um DTO em vez de entidade direta, por exemplo: `CriarUsuarioRequestDTO`.  
- Crie um package `dto.mapper` para centralizar a conversão entre DTO e entidade (ex.: `CriarUsuarioRequestMapper.toEntity(dto)`).

---

## Anotações de Validação (Bean Validation)  
No DTO, aplique validações em cada atributo:  
- `@NotBlank(message = "Nome não pode ser nulo")`  
- `@Size(min = 3, message = "Nome deve conter pelo menos 3 caracteres")`  
- `@Email(message = "Email está fora do padrão")`  
- `@NotBlank(message = "Senha não pode ser vazia")`  
- `@Size(min = 8, message = "Senha deve conter no mínimo 8 dígitos")`  
- `@NotNull(message = "Idade não pode ser nula")`  
- `@Positive(message = "Idade não pode ser negativa")`

---

## Recebendo e Validando no Controller  
No método do controller, combine `@RequestBody` com `@Valid` para ativar as validações do DTO:  
    
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(
        @RequestBody @Valid CriarUsuarioRequestDTO usuarioDto
    ) {
        Usuario entity = CriarUsuarioRequestMapper.toEntity(usuarioDto);
        Usuario criado = criarUsuarioService.criarUsuario(entity);
        return ResponseEntity.status(CREATED).body(criado);
    }

- `@Valid` faz o Spring disparar erros de validação definidos no DTO (NotBlank, Size, etc.).  
- Se alguma regra falhar, retorna automaticamente 400 Bad Request com detalhes das violações.