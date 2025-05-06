package tech.ada.yuri.ml_users.dto.usuario.mapper;

import tech.ada.yuri.ml_users.dto.endereco.mapper.EnderecoDTOMapper;
import tech.ada.yuri.ml_users.dto.usuario.UsuarioDTO;
import tech.ada.yuri.ml_users.model.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEndereco(EnderecoDTOMapper.toDto(usuario.getEndereco()));
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setIdade(usuario.getIdade());
        usuarioDTO.setNome(usuario.getNome());
        return usuarioDTO;
    }
}
