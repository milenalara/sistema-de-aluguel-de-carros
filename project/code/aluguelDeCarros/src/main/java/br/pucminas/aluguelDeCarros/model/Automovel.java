package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "automovel")
public class Automovel {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "matricula", length = 50, nullable = false)
    private String matricula;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "placa", length = 50, nullable = false, unique = true)
    private String placa;

    @Enumerated(EnumType.STRING)
    private Proprietario proprietario;

    @OneToMany(mappedBy = "automovel", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
}
