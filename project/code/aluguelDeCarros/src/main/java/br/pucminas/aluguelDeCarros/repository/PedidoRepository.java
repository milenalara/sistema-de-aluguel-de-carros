package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    


}
