package br.pucminas.aluguelDeCarros;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "rg",length = 50, nullable = false)
    private String rg;

    @Column(name = "cpf", length = 50, nullable = false)
    private String cpf;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;

    @Column(name = "profissao", length = 50, nullable = false)
    private String profissao;

    @Column(name = "empregador", length = 50, nullable = false)
    private String empregador;

    @Column(name = "rendimentos", length = 50, nullable = false)
    private String rendimentos;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

}
