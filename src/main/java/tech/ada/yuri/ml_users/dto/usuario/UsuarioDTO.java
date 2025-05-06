package tech.ada.yuri.ml_users.dto.usuario;

import tech.ada.yuri.ml_users.dto.endereco.EnderecoDTO;

public class UsuarioDTO {
    private String nome;
    private String email;
    private int idade;
    private EnderecoDTO endereco;

    public UsuarioDTO() {

    }

    public UsuarioDTO(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
