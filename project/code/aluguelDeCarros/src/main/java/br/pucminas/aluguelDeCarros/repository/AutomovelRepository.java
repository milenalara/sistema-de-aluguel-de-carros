package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Automovel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomovelRepository extends CrudRepository<Automovel, Long> {
  List<Automovel> findAll();
}
