package edu.mx.tecdesoftware.marketbackend_3A.domain.repository;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(Integer categoryId);
    public Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productoId);
}
