package br.pucminas.aluguelDeCarros;

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

}
