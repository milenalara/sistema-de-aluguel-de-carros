package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    


}
