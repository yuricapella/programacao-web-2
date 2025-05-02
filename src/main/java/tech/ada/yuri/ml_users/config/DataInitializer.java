package tech.ada.yuri.ml_users.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.ada.yuri.ml_users.model.Usuario;
import tech.ada.yuri.ml_users.service.CriarUsuarioService;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsuarios(CriarUsuarioService criarUsuarioService) {
        return args -> {
            if (criarUsuarioService != null) {
                List<Usuario> usuarios = List.of(
                        new Usuario("João Silva", "joao.silva@email.com", "senha123", 30),
                        new Usuario("Maria Oliveira", "maria.oliveira@email.com", "senha456", 25),
                        new Usuario("Pedro Santos", "pedro.santos@email.com", "senha789", 35),
                        new Usuario("Ana Rodrigues", "ana.rodrigues@email.com", "senhaabc", 28),
                        new Usuario("Lucas Pereira", "lucas.pereira@email.com", "senhaxyz", 40)
                );

                usuarios.forEach(criarUsuarioService::criarUsuario);
            }
        };
    }
}