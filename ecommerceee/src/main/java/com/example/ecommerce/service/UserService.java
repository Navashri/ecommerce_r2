package com.example.ecommerce.service;

import java.util.List;

// import org.springdoc.core.converters.models.Pageable;
// import org.springdoc.core.converters.models.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Orders;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    @Autowired
    public UserService(UserRepository userRepository,
                       ProductRepository productRepository,
                       OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
       
    }

    // User methods
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Product methods
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Order methods
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getchild(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return userRepository.findAll(sort);
    }

    public List<User> gettchild(int offset, int pagesize) {
        Pageable page = PageRequest.of(offset,pagesize);
        return userRepository.findAll(page).getContent();
    }

    public List<User> getttchild(int offset, int pagesize, String field) {
        return userRepository.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}
