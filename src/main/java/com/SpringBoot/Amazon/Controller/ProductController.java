package com.SpringBoot.Amazon.Controller;

import com.SpringBoot.Amazon.Model.Product;
import com.SpringBoot.Amazon.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class ProductController {

    private final ProductService service;

    @GetMapping("/get/product")
    public List<Product> getApi () {
        return service.getProduct();
    }

    @PostMapping("/post/product")
    public String postApi(@Valid @RequestBody Product product){
        return service.postProduct(product);
    }

    @PutMapping("/put/product/{id}")
    public String putApi(@Valid @RequestBody Product product, @PathVariable long id){
        product.setId(id);
        return service.putProduct(product);
    }

    @DeleteMapping("/delete/product/{id}")
    public String deleteApi (@Valid @PathVariable long id) {
        return service.deleteProduct(id);
    }

    @DeleteMapping("/delete/ListOfProduct")
    public String deleteListApi (@Valid @RequestBody List<Long> product){
        return service.deleteListOfProduct(product);
    }

    @GetMapping("/getQuery/product/{id}")
    public List<Product> queryGetApi (@Valid @PathVariable Set<Long> id){
        return service.queryProduct(id);
    }

}

