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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
}
