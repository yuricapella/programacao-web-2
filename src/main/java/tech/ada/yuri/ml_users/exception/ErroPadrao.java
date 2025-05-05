package tech.ada.yuri.ml_users.exception;

import java.time.LocalDate;
import java.util.Map;

public class ErroPadrao {
    private String codigoErro;
    private LocalDate dataHoraErro;
    private String mensagemErro;
    private Map<String, String> errors;



    public String getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(String codigoErro) {
        this.codigoErro = codigoErro;
    }

    public LocalDate getDataHoraErro() {
        return dataHoraErro;
    }

    public void setDataHoraErro(LocalDate dataHoraErro) {
        this.dataHoraErro = dataHoraErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
