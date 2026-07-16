package edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud;

import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<Compra> findByIdCliente(String clienteId);
}