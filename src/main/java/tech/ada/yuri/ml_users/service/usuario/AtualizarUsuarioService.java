package tech.ada.yuri.ml_users.service.usuario;

import org.springframework.stereotype.Service;

import tech.ada.yuri.ml_users.dto.usuario.AtualizarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.usuario.mapper.AtualizarUsuarioRequestMapper;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;

@Service
public class AtualizarUsuarioService {
    private final BuscarUsuarioService buscarUsuarioService;
    private final UsuarioRepository usuarioRepository;

    public AtualizarUsuarioService(BuscarUsuarioService buscarUsuarioService, UsuarioRepository usuarioRepository) {
        this.buscarUsuarioService = buscarUsuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario atualizarUsuario(AtualizarUsuarioRequestDTO usuarioAtualizado, Long id) {
        Usuario usuarioExistente = buscarUsuarioService.buscarUsuarioPorId(id);
        AtualizarUsuarioRequestMapper.updateEntity(usuarioExistente, usuarioAtualizado);
        return usuarioRepository.save(usuarioExistente);
    }

}
