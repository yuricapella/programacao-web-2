package tech.ada.yuri.ml_users.service;

import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.dto.AtualizarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.mapper.AtualizarUsuarioRequestMapper;
import tech.ada.yuri.ml_users.model.Usuario;

@Service
public class AtualizarUsuarioService {
    private final BuscarUsuarioService buscarUsuarioService;
    private final CriarUsuarioService criarUsuarioService;

    public AtualizarUsuarioService(BuscarUsuarioService buscarUsuarioService, CriarUsuarioService criarUsuarioService) {
        this.buscarUsuarioService = buscarUsuarioService;
        this.criarUsuarioService = criarUsuarioService;
    }

    public Usuario atualizarUsuario(AtualizarUsuarioRequestDTO usuarioAtualizado, Long id) {
        Usuario usuarioExistente = buscarUsuarioService.buscarUsuarioPorId(id);
        AtualizarUsuarioRequestMapper.updateEntity(usuarioExistente, usuarioAtualizado);
        return criarUsuarioService.criarUsuario(usuarioExistente);
    }

}
