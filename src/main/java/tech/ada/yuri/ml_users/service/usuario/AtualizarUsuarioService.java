package tech.ada.yuri.ml_users.service.usuario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tech.ada.yuri.ml_users.dto.usuario.AtualizarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.usuario.mapper.AtualizarUsuarioRequestMapper;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;

@Service
public class AtualizarUsuarioService {
    private final BuscarUsuarioService buscarUsuarioService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AtualizarUsuarioService(BuscarUsuarioService buscarUsuarioService, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.buscarUsuarioService = buscarUsuarioService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario atualizarUsuario(AtualizarUsuarioRequestDTO usuarioAtualizado, Long id) {
        Usuario usuarioExistente = buscarUsuarioService.buscarUsuarioPorId(id);
        AtualizarUsuarioRequestMapper.updateEntity(usuarioExistente, usuarioAtualizado);
        usuarioExistente.setSenha(passwordEncoder.encode(usuarioExistente.getSenha()));
        return usuarioRepository.save(usuarioExistente);
    }

}
