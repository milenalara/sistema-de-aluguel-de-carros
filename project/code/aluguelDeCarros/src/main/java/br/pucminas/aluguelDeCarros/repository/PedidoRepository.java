package br.pucminas.aluguelDeCarros.repository;

import br.pucminas.aluguelDeCarros.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

  List<Pedido> findPedidosByConfirmado(Boolean confirmado);


}
