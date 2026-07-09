package edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud;

import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    List<Compra> findByIdCliente(String idCliente);
}