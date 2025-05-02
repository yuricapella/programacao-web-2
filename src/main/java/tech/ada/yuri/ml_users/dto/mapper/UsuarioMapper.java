package tech.ada.yuri.ml_users.dto.mapper;

import tech.ada.yuri.ml_users.dto.UsuarioDTO;
import tech.ada.yuri.ml_users.model.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setIdade(usuario.getIdade());
        usuarioDTO.setNome(usuario.getNome());
        return usuarioDTO;
    }
}
