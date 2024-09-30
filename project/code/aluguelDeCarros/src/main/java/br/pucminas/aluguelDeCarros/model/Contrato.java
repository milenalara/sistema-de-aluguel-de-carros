package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contrato")
public class Contrato {
  @Id
  @Column(name = "id", nullable = false)
  Long id;

  @Column(name = "duracao")
  Integer duracao;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getDuracao() {
    return duracao;
  }

  public void setDuracao(Integer duracao) {
    this.duracao = duracao;
  }
}
