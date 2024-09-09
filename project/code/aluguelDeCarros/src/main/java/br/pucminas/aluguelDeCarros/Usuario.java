package br.pucminas.aluguelDeCarros;

import jakarta.persistence.*;

@MappedSuperclass
public class Usuario {
 
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "login",length = 50, nullable = false)
    private String login;

    @Column(name = "senha", length = 50, nullable = false)
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

}
