package edu.mx.tecdesoftware.marketbackend_3A.pesistence;

import edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud.ProductoCrudRepository;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //SELECT * FROM productos
    public List<Producto> getAll(){
        //Se "castea" de Iterable a la Lista
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Optional<List<Producto>> getByCategoria(int idCategoria) {
        return Optional.ofNullable(productoCrudRepository.findByCategoriaOrderByNombreAsc(idCategoria));
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(
                cantidad, true
        );
    }

    //Obtener un prodcuto dado el ID
    public Optional<Producto> getProductoId(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    //Guardar un producto
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    //Eliminar por id
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
