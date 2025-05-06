package tech.ada.yuri.ml_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.yuri.ml_users.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByOrderByNomesAsc();

    List<Usuario> findByIdadeBetween(int idadInicial, int idadeFinal);

    List<Usuario> findByEmailEndingWith(String dominio);

    @Query(value = "SELECT u.* FROM USUARIO u JOIN ENDERECO e ON u.endereco_id = e.id WHERE e.cep = :cepEndereco",
            nativeQuery = true)
    List<Usuario> buscarUsuarioPorCep(@Param("cepEndereco") String cepEndereco);

    @Query("SELECT u FROM Usuario u WHERE u.dataAtualizacao BETWEEN :inicio AND :fim")
    List<Usuario> buscarUsuariosAtualizadosNoPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

}
