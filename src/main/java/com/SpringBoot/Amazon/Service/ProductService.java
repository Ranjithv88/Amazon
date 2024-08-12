package com.SpringBoot.Amazon.Service;

import com.SpringBoot.Amazon.Model.Product;
import com.SpringBoot.Amazon.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public String postProduct (Product product) {
        repository.save(product);
        return " Product SuccessFully Added .......! ";
    }

    public String putProduct(Product product) {
        repository.save(product);
        return " Product SuccessFully Updated .......! ";
    }

    public String deleteProduct(long id) {
        repository.deleteById(id);
        return " Product Delete SuccessFully .......! ";
    }

    public String deleteListOfProduct(List<Long> product) {
        for (Long id:product) {
            repository.deleteById(id);
        }
        return " Products Delete SuccessFully .......! ";
    }

    public List<Product> queryProduct(Set<Long> id) {
        return repository.getId(id);
    }

}

