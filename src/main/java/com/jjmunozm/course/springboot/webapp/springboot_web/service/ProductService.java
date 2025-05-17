package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Product;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product AddProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product){
        Optional<Product> productExist = productRepository.findById(id);
        if(productExist.isPresent()){
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public boolean deleteProduct(int id){
        Optional<Product> productExist = productRepository.findById(id);
        if(productExist.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Product> ProductFilterByDescription (String filter){
        String fixFilter = "%"+filter+"%";
        return productRepository.findProductsbyShortName(fixFilter);
    }

    public List<Product> getProductsOrderByName(){
        return productRepository.findProductsOrderByName();
    }

    public List<Product> getProductsRangePrice(double min, double max){
        return productRepository.findProductsRangePrice(min, max);
    }

    public List<Product> getProductsByCategory(int id_category){
        return productRepository.findProductsByCategory(id_category);
    }

}
