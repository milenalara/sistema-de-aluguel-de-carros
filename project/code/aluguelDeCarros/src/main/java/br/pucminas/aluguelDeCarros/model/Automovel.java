package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.*;


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

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "placa", length = 50, nullable = false, unique = true)
    private String placa;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    
    
}
