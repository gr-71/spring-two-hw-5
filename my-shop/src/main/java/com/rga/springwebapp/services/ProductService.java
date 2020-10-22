package com.rga.springwebapp.services;

import com.rga.springwebapp.domain.Product;
import com.rga.springwebapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product getProductByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public com.rga.springwebapp.ws.products.Product getProduct(String  title) throws DatatypeConfigurationException {
        com.rga.springwebapp.ws.products.Product product = new com.rga.springwebapp.ws.products.Product();
        product.setTitle(productRepository.findOneByTitle(title).getTitle());
        return product;
    }

}
