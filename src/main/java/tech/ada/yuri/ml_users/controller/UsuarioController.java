
package tech.ada.yuri.ml_users.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.yuri.ml_users.dto.usuario.AtualizarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.usuario.CriarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.usuario.UsuarioDTO;
import tech.ada.yuri.ml_users.dto.usuario.mapper.CriarUsuarioRequestMapper;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.service.usuario.AtualizarUsuarioService;
import tech.ada.yuri.ml_users.service.usuario.BuscarUsuarioService;
import tech.ada.yuri.ml_users.service.usuario.CriarUsuarioService;
import tech.ada.yuri.ml_users.service.usuario.DeletarUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios") //quando usuario usar localhost usuarios, vai cair aqui
public class UsuarioController {

    private final BuscarUsuarioService buscarUsuarioService;
    private final CriarUsuarioService criarUsuarioService;
    private final AtualizarUsuarioService atualizarUsuarioService;
    private final DeletarUsuarioService deletarUsuario;

    public UsuarioController(BuscarUsuarioService buscarUsuarioService, CriarUsuarioService criarUsuarioService, AtualizarUsuarioService atualizarUsuarioService, DeletarUsuarioService deletarUsuario) {
        this.buscarUsuarioService = buscarUsuarioService;
        this.criarUsuarioService = criarUsuarioService;
        this.atualizarUsuarioService = atualizarUsuarioService;
        this.deletarUsuario = deletarUsuario;
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários",
            description = "Retorna uma lista de todos os usuários cadastrados.")
    public List<UsuarioDTO> buscarTodosOsUsuarios() {
        return buscarUsuarioService.buscarTodosOsUsuarios();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Buscar usuário por ID",
            description = "Retorna um usuário especifico com base no ID")
    public Usuario buscarUsuarioPorId(@PathVariable(value = "id") Long id) {
        return buscarUsuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping
    @Operation(summary = "Criar um novo usuário",
            description = "Cria um novo usuário com os dados fornecidos")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid CriarUsuarioRequestDTO usuario) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarUsuarioService.criarUsuario(CriarUsuarioRequestMapper.toEntity(usuario)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um usuário existente",
            description = "Atualiza os dados de um usuário existente com base no ID fornecido.")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid AtualizarUsuarioRequestDTO usuarioAtualizado, @PathVariable(value = "id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atualizarUsuarioService.atualizarUsuario(usuarioAtualizado, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um usuário",
            description = "Deleta um usuário específico com base no ID fornecido.")
    public ResponseEntity<Void> deletarUsuario(@PathVariable(value = "id") Long id) {
        deletarUsuario.deletarUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
