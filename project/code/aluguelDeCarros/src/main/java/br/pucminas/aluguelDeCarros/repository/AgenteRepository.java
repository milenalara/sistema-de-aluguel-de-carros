package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Agente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenteRepository extends CrudRepository<Agente, Long> {
    
  List<Agente> findAll();

}
