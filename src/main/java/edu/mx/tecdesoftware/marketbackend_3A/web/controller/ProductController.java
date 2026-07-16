package edu.mx.tecdesoftware.marketbackend_3A.web.controller;

import edu.mx.tecdesoftware.marketbackend_3A.domain.Product;
import edu.mx.tecdesoftware.marketbackend_3A.domain.repository.ProductRepository;
import edu.mx.tecdesoftware.marketbackend_3A.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product", description = "Manage products in the store")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Se eliminó ProductRepository, ya que el controlador solo debe interactuar con el Service.

    @GetMapping("/all")
    @Operation(summary = "Get all products", description = "Return a list of all available products")
    @ApiResponse(responseCode = "200", description = "Succesful retrieval of products")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Return a product by its ID if it exists")
    @ApiResponse(responseCode = "200", description = "Product found")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "500", description = "Interval server error")
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "ID of the product retrieved",
            example = "7", required = true)
            @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get a product by category", description = "Return all products in a specific category")
    @ApiResponse(responseCode = "200", description = "Product found in the category")
    @ApiResponse(responseCode = "404", description = "Product not found in the category")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Product>> getByCategory(
            @PathVariable @Parameter(description = "Category ID", example = "2", required = true) int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> products.isEmpty() ? new ResponseEntity<>(products, HttpStatus.NO_CONTENT) : ResponseEntity.ok(products))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @Operation(summary = "Save a new product", description = "Register a new product and return the created product",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, content = @Content(examples = @ExampleObject(
            name = "Example product",
            value = """
            {
                "name" : "Mirinda",
                "categoryId" : "5",
                "price" : "20.50",
                "stock" : 300,
                "active" : true
            }
            """))))
    @ApiResponse(responseCode = "201", description = "Product created succesfully")
    @ApiResponse(responseCode = "400", description = "Invalid product data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Product conflict (duplicate code or SKU)")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product by ID",
        description = "Delete a product if it exists")
    @ApiResponse(responseCode = "200", description = "Product deleted succesfully")
    @ApiResponse(responseCode = "400", description = "Invalid prodcut ID")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "500", description = "Internal server server")
    public ResponseEntity<Void> delete(@PathVariable("id") int productId) {
        return productService.delete(productId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}