package com.SpringBoot.Amazon.Service;

import com.SpringBoot.Amazon.Model.Address;
import com.SpringBoot.Amazon.Model.Cart;
import com.SpringBoot.Amazon.Repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repository;

    public List<Cart> getCart () {
        return repository.findAll();
    }

    public String postCart (Cart cart) {
        repository.save(cart);
        return " Cart SuccessFully Added .......! ";
    }

    public String putCart(Cart cart) {
        repository.save(cart);
        return " Cart SuccessFully Updated .......! ";
    }

    public String deleteCart(long id) {
        repository.deleteById(id);
        return " Cart Delete SuccessFully .......! ";
    }

    public String deleteListOfCart(List<Long> cart) {
        for (Long id:cart) {
            repository.deleteById(id);
        }
        return " Carts Delete SuccessFully .......! ";
    }

    public List<Cart> queryCart(Set<Long> id) {
        return repository.getId(id);
    }

}

