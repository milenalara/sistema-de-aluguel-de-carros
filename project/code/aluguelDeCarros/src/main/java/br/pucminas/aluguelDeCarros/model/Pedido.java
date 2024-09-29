package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "confirmado", nullable = false)
    private boolean confirmado;

    @Column(name = "contrato",length = 50, nullable = true)
    private String contrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente.id")
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente.id")
    private Agente agente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automovel.id")
    private Automovel automovel;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public boolean isConfirmado() {
        return confirmado;
    }


    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Agente getAgente() {
        return agente;
    }


    public void setAgente(Agente agente) {
        this.agente = agente;
    }


    public Automovel getAutomovel() {
        return automovel;
    }


    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }


    public String getContrato() {
        return contrato;
    }


    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    
}
