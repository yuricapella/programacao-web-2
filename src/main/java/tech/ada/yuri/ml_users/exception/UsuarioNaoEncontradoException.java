package tech.ada.yuri.ml_users.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(Long id) {
        super("Usuário com id " + id + " não encontrado.");
    }
}
