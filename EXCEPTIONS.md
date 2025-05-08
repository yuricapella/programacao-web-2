## Tratamento de Erros

O projeto implementa um sistema robusto de tratamento de erros através do `ControllerAdviceRest` e classes de exceção personalizadas.

### Classes de Exceção

1. **UsuarioNaoEncontradoException**
   - Lançada quando um usuário não é encontrado no sistema
   - Possui dois construtores:
     - `UsuarioNaoEncontradoException(String message)`: para mensagens personalizadas
     - `UsuarioNaoEncontradoException(Long id)`: para quando o usuário não é encontrado por ID

2. **ErroPadrao**
   - Classe que padroniza o formato das respostas de erro
   - Atributos:
     - `codigoErro`: código do erro (enum ErroCodigo)
     - `dataHora`: timestamp do erro
     - `mensagem`: descrição do erro
     - `errors`: mapa de erros de validação (campo -> mensagem)

3. **ErroCodigo**
   - Enum que define os tipos de erro possíveis:
     - `USUARIO_NAO_ENCONTRADO`
     - `CAMPO_INVALIDO`
     - `EMAIL_JA_CADASTRADO`
     - `ERRO_GENERICO`

### Tratamento de Exceções (ControllerAdviceRest)

1. **UsuarioNaoEncontradoException**
   - Status: 404 Not Found
   - Retorna apenas o status sem corpo

2. **DataIntegrityViolationException**
   - Status: 409 Conflict
   - Retorna ErroPadrao com:
     - Código: EMAIL_JA_CADASTRADO
     - Mensagem: "Email já cadastrado no sistema"

3. **MethodArgumentNotValidException**
   - Status: 400 Bad Request
   - Retorna ErroPadrao com:
     - Código: CAMPO_INVALIDO
     - Mensagem: "Ocorreu um erro na validação dos campos"
     - Mapa de erros detalhando cada campo inválido

4. **Exception (Genérica)**
   - Status: 500 Internal Server Error
   - Retorna ErroPadrao com:
     - Código: ERRO_GENERICO
     - Mensagem: mensagem original da exceção

### Validações de Campos
Os DTOs implementam validações usando anotações do Jakarta Validation:

- **CriarUsuarioRequestDTO e AtualizarUsuarioRequestDTO**:
  - Nome: @NotBlank, @Size(min=3)
  - Email: @Email
  - Senha: @NotBlank, @Size(min=3)
  - Idade: @NotNull, @Positive
  - CEP: @NotBlank, @Size(min=8,max=8)

### Erros de Autenticação
O Spring Security trata automaticamente:
- Credenciais inválidas
- Usuário não encontrado
- Token inválido
- Acesso não autorizado

### Exemplo de Resposta de Erro
```json
{
    "codigoErro": "CAMPO_INVALIDO",
    "dataHora": "2024-03-21T10:30:00",
    "mensagem": "Ocorreu um erro na validação dos campos",
    "errors": {
        "email": "Email está fora do padrão",
        "senha": "Senha deve conter no minimo 8 digitos"
    }
}
```

Este sistema de tratamento de erros fornece respostas claras e padronizadas para diferentes tipos de erros que podem ocorrer na aplicação, facilitando o debug e a integração com outros sistemas.
