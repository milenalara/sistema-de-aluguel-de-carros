package br.pucminas.aluguelDeCarros.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
 
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "login",length = 50, nullable = false)
    private String login;

    @Column(name = "senha", length = 50, nullable = false)
    private String senha;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Automovel> Automovel = new ArrayList<>();

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

    public List<Automovel> getAutomovel() {
        return Automovel;
    }

    public void setAutomovel(List<Automovel> automovel) {
        Automovel = automovel;
    }

    

}
