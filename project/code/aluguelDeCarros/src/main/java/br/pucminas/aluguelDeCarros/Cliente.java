package br.pucminas.aluguelDeCarros;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario{

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmpregador() {
        return empregador;
    }

    public void setEmpregador(String empregador) {
        this.empregador = empregador;
    }

    public String getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(String rendimentos) {
        this.rendimentos = rendimentos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    

}
