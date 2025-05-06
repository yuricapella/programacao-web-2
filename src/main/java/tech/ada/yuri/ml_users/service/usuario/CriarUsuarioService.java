package tech.ada.yuri.ml_users.service.usuario;

import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;
import tech.ada.yuri.ml_users.service.endereco.EnderecoService;

@Service
public class CriarUsuarioService {
    private final UsuarioRepository usuariosRepository;
    private final EnderecoService enderecoService;

    public CriarUsuarioService(UsuarioRepository usuariosRepository, EnderecoService enderecoService) {
        this.usuariosRepository = usuariosRepository;
        this.enderecoService = enderecoService;
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setEndereco(enderecoService.obterEnderecoPorCep(usuario.getEndereco().getCep()));
        return usuariosRepository.save(usuario);
    }
}
