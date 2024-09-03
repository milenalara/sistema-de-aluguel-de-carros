package br.pucminas.aluguelDeCarros;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "confirmado", nullable = false)
    private boolean confirmado;

    @Column(name = "credito", nullable = false)
    private boolean credito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente.id")
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente.id")
    private Agente agente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automovel.id")
    private Automovel automovel;
}
