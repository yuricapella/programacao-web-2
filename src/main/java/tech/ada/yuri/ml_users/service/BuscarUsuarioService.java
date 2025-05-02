package tech.ada.yuri.ml_users.service;

import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.dto.UsuarioDTO;
import tech.ada.yuri.ml_users.dto.mapper.UsuarioMapper;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuscarUsuarioService {
    UsuariosRepository usuariosRepository;

    public BuscarUsuarioService(UsuariosRepository usuariosRepository) {
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
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + id + " não encontrado"));
    }
}
