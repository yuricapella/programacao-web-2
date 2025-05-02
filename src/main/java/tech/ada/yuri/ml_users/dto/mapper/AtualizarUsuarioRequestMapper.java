package tech.ada.yuri.ml_users.dto.mapper;

import tech.ada.yuri.ml_users.dto.AtualizarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.CriarUsuarioRequestDTO;
import tech.ada.yuri.ml_users.dto.UsuarioDTO;
import tech.ada.yuri.ml_users.model.Usuario;

import java.time.LocalDateTime;

public class AtualizarUsuarioRequestMapper {

    public static Usuario updateEntity(Usuario usuarioExistente, AtualizarUsuarioRequestDTO usuarioAtualizado) {
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());
        usuarioExistente.setIdade(usuarioAtualizado.getIdade());
        usuarioExistente.setDataAtualizacao(LocalDateTime.now());
        return usuarioExistente;
    }

}
