package tech.ada.yuri.ml_users.service.usuario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.repository.UsuarioRepository;
import tech.ada.yuri.ml_users.service.endereco.EnderecoService;

@Service
public class CriarUsuarioService {
    private final UsuarioRepository usuariosRepository;
    private final EnderecoService enderecoService;
    private final PasswordEncoder passwordEncoder;

    public CriarUsuarioService(UsuarioRepository usuariosRepository, EnderecoService enderecoService, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.enderecoService = enderecoService;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setEndereco(enderecoService.obterEnderecoPorCep(usuario.getEndereco().getCep()));
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuariosRepository.save(usuario);
    }
}
