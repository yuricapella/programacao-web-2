package tech.ada.yuri.ml_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.yuri.ml_users.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
