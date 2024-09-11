package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.*;

@MappedSuperclass
public class Empregador {
 
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "nome",length = 50, nullable = false)
    private String nome;

    @Column(name = "cpnj", length = 50, nullable = false)
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
