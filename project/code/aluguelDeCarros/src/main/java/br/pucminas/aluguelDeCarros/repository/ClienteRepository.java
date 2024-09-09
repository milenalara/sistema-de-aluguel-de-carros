package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    


}
