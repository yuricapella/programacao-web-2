package tech.ada.yuri.ml_users.service.usuario;

import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;

@Service
public class DeletarUsuarioService {
    BuscarUsuarioService buscarUsuarioService;
    UsuarioRepository usuariosRepository;

    public DeletarUsuarioService(BuscarUsuarioService buscarUsuarioService, UsuarioRepository usuariosRepository) {
        this.buscarUsuarioService = buscarUsuarioService;
        this.usuariosRepository = usuariosRepository;
    }

    public void deletarUsuarioPorId(Long id) {
        buscarUsuarioService.buscarUsuarioPorId(id);
        usuariosRepository.deleteById(id);
    }
}
