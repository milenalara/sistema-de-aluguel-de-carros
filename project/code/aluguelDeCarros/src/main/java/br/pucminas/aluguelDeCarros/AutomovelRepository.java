package br.pucminas.aluguelDeCarros;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovelRepository extends CrudRepository<Automovel, Long> {
    


}
