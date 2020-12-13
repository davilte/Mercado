package com.mercado.MercadoAdm.service;

import com.mercado.MercadoAdm.model.Product;
import com.mercado.MercadoAdm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product register(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(Long id) {
        if (!this.productRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        return this.productRepository.getOne(id);
    }

    @Transactional
    public void update(Long id, Product product) {
        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt == null) {
            throw new RuntimeException("Produto não existe!");
        }

        Product productBD = productOpt.get();
        if(productBD.getId() != null) {
            productBD.setPrice(productBD.getPrice());
            productBD.setQuantity(productBD.getQuantity());

            productRepository.save(productBD);
        } else {
            throw  new RuntimeException("Não é possível atualizar este produto!");
        }
    }

    public void delete(Long id) {
        if (!this.productRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        this.productRepository.deleteById(id);
    }
}
