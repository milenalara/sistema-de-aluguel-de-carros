package br.pucminas.aluguelDeCarros.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "agente")
public class Agente extends Usuario{

    @Column(name = "cnpj", length = 50, nullable = false)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private TipoAgente tipo;

    @OneToMany(mappedBy = "agente", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public TipoAgente getTipo() {
        return tipo;
    }

    public void setTipo(TipoAgente tipo) {
        this.tipo = tipo;
    }

    public String getCpnj() {
        return cnpj;
    }

    public void setCpnj(String cpnj) {
        this.cnpj = cpnj;
    }

    
    
}
