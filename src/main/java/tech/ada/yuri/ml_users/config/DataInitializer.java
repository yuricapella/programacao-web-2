package tech.ada.yuri.ml_users.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.ada.yuri.ml_users.model.Endereco;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.service.usuario.CriarUsuarioService;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner carregarUsuariosIniciais(CriarUsuarioService criarUsuarioService) {
        return args -> {
            if (criarUsuarioService != null) {

                Endereco enderecoPadrao = new Endereco();
                enderecoPadrao.setCep("01001000");

                List<Usuario> listaDeUsuarios = List.of(
                        new Usuario("João Silva", "joao.silva@email.com", "senha123", 30, enderecoPadrao),
                        new Usuario("Maria Oliveira", "maria.oliveira@email.com", "senha456", 25, enderecoPadrao),
                        new Usuario("Pedro Santos", "pedro.santos@email.com", "senha789", 35, enderecoPadrao),
                        new Usuario("Ana Rodrigues", "ana.rodrigues@email.com", "senhaabc", 28, enderecoPadrao),
                        new Usuario("Lucas Pereira", "lucas.pereira@email.com", "senhaxyz", 40, enderecoPadrao)
                );

                listaDeUsuarios.forEach(criarUsuarioService::criarUsuario);
            }
        };
    }
}