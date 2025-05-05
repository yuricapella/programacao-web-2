
package tech.ada.yuri.ml_users.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.yuri.ml_users.dto.AtualizarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.CriarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.UsuarioDTO;
import tech.ada.yuri.ml_users.dto.mapper.AtualizarUsuarioRequestMapper;
import tech.ada.yuri.ml_users.dto.mapper.CriarUsuarioRequestMapper;
import tech.ada.yuri.ml_users.exception.UsuarioNaoEncontradoException;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.service.AtualizarUsuarioService;
import tech.ada.yuri.ml_users.service.BuscarUsuarioService;
import tech.ada.yuri.ml_users.service.CriarUsuarioService;
import tech.ada.yuri.ml_users.service.DeletarUsuarioService;

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
    public List<UsuarioDTO> buscarTodosOsUsuarios() {
        return buscarUsuarioService.buscarTodosOsUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable(value = "id") Long id) {
        return buscarUsuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid CriarUsuarioRequestDTO usuario) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarUsuarioService.criarUsuario(CriarUsuarioRequestMapper.toEntity(usuario)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid AtualizarUsuarioRequestDTO usuarioAtualizado, @PathVariable(value = "id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atualizarUsuarioService.atualizarUsuario(usuarioAtualizado, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable(value = "id") Long id) {
        deletarUsuario.deletarUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
