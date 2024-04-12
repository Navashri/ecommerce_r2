package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.ecommerce.model.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    default Product saveProduct(Product product) {
        return save(product);
    }

    default List<Product> getAllProducts() {
        return findAll();
    }

    default Product getProductById(Long id) {
        return findById(id).orElse(null);
    }

    default void deleteProduct(Long id) {
        deleteById(id);
    }

    @Query("SELECT p FROM Product p WHERE p.price < :maxPrice")
    List<Product> findProductsByPriceLessThan(@Param("maxPrice") Double maxPrice);

}
