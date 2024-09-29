package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
  @Id
  @Column(name = "id", nullable = false)
  Long id;

  @Column(name = "duracao", nullable = false)
  Integer duracao;
}
