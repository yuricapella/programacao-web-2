package tech.ada.yuri.ml_users.service.usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.ada.yuri.ml_users.dto.usuario.UsuarioDTO;
import tech.ada.yuri.ml_users.dto.usuario.mapper.UsuarioMapper;
import tech.ada.yuri.ml_users.exception.UsuarioNaoEncontradoException;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;

@Service
public class BuscarUsuarioService {
    private final UsuarioRepository usuariosRepository;

    public BuscarUsuarioService(UsuarioRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<UsuarioDTO> buscarTodosOsUsuarios() {
        return usuariosRepository.findAll()
                .stream()
                .map(UsuarioMapper::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);
        return usuarioOptional
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}
