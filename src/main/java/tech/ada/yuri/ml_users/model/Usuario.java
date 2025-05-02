package tech.ada.yuri.ml_users.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity //Ja sinaliza que é uma entidade da Jpa Hibernate
@Table(name = "USUARIO")

public class Usuario {

    @Id  // usar o jakarta para dizer que Long id é a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY, SEQUENCE, depende do banco de dados
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String email;
    private String senha;
    private int idade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Usuario() {
        if(dataCriacao == null){
            this.dataCriacao = LocalDateTime.now();
        }

    }

    public Usuario(String nome, String email, String senha, int idade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
