package com.decorperson.calculadoradecorperson.services;

import com.decorperson.calculadoradecorperson.dto.ProductDTO;
import com.decorperson.calculadoradecorperson.entities.Product;
import com.decorperson.calculadoradecorperson.repository.ProductRepository;
import com.decorperson.calculadoradecorperson.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
                return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String name, Pageable pageable) {
        Page<Product> result = repository.searchByName(name, pageable);
        return result.map(x -> new ProductDTO(x));
    }
}
