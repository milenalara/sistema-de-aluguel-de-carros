package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Agente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends CrudRepository<Agente, Long> {
    


}
