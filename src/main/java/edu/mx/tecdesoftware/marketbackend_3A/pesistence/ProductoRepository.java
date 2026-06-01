package edu.mx.tecdesoftware.marketbackend_3A.pesistence;

import edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud.ProductoCrudRepository;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //SELECT * FROM productos
    public List<Producto> getAll(){
        //Se "castea" de Iterable a la Lista
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
