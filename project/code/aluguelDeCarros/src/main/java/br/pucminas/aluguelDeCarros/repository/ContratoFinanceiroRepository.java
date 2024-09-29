package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.ContratoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoFinanceiroRepository extends JpaRepository<ContratoFinanceiro, Long> {
}
