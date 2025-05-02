package tech.ada.yuri.ml_users.service;

import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuariosRepository;

@Service
public class CriarUsuarioService {
    private final UsuariosRepository usuariosRepository;

    public CriarUsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }
}
