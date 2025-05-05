package tech.ada.yuri.ml_users.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.ada.yuri.ml_users.exception.CodigoErro;
import tech.ada.yuri.ml_users.exception.ErroPadrao;
import tech.ada.yuri.ml_users.exception.UsuarioNaoEncontradoException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceRest {

    @ExceptionHandler({UsuarioNaoEncontradoException.class})
    public ResponseEntity<Void> handlerUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErroPadrao> handlerException(Exception ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setCodigoErro(CodigoErro.ERRO_GENERICO.name());
        erroPadrao.setDataHoraErro(LocalDate.now());
        erroPadrao.setMensagemErro(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroPadrao);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErroPadrao> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setCodigoErro(CodigoErro.CAMPO_INVALIDO.name());
        erroPadrao.setDataHoraErro(LocalDate.now());
        erroPadrao.setMensagemErro("Ocorreu um erro na validação dos campos");

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
                String campo = ((FieldError) erro).getField();
                String mensagemErroCampo = erro.getDefaultMessage();
                errors.put(campo, mensagemErroCampo);
        });

        erroPadrao.setErrors(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadrao);
    }


}
