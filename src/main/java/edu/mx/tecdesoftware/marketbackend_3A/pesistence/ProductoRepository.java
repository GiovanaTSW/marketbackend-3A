package edu.mx.tecdesoftware.marketbackend_3A.pesistence;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Product;
import edu.mx.tecdesoftware.marketbackend_3A.domain.repository.ProductRepository;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.crud.ProductoCrudRepository;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity.Producto;
import edu.mx.tecdesoftware.marketbackend_3A.pesistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Le dices a Spring que esta clase
//Se comunicará con la BD

public class ProductoRepository implements ProductRepository {
    private ProductMapper productMapper;
    private ProductoCrudRepository productoCrudRepository;

    //SELECT * FROM productos
    public List<Product> getAll(){
        //Se "castea" de Iterable a la Lista
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }


    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }


    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,
                true);
        return Optional.of(productMapper.toProducts(productos.get()));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    //Obtener un prodcuto dado el ID
    public Optional<Product> getProducto(int productId) {

        return productoCrudRepository.findById(productId)
                .map(producto -> productMapper.toProduct(producto));
    }

    //Guardar un producto
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    //Eliminar por id
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
