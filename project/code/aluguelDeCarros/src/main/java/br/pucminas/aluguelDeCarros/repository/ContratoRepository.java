package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
