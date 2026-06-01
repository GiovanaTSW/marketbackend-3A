package edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud;


import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository
        extends CrudRepository<Producto, Integer> {
}
