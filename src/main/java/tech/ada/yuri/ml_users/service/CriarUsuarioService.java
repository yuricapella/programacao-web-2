package tech.ada.yuri.ml_users.service;

import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;

@Service
public class CriarUsuarioService {
    private final UsuarioRepository usuariosRepository;

    public CriarUsuarioService(UsuarioRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }
}
