package br.pucminas.aluguelDeCarros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContratoFinanceiro extends Contrato {
  Boolean clienteCompraVeiculo;

  public ContratoFinanceiro() {
    super();
    clienteCompraVeiculo = false;
  }
}
