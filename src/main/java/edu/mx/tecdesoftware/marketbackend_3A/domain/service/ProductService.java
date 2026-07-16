package edu.mx.tecdesoftware.marketbackend_3A.domain.service;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Product;
import edu.mx.tecdesoftware.marketbackend_3A.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(Integer productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(Integer categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public  Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        //Verficar que existe antes de borrar
        if(getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }{
            return false;
        }
    }
}
