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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = true)
    private Contrato contrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id")
    private Agente agente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automovel_id")
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


    public Contrato getContrato() {
        return contrato;
    }


    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    
}
