package br.pucminas.aluguelDeCarros;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "agente")
public class Agente {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "agente", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

}
