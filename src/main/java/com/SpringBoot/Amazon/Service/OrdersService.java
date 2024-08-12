package com.SpringBoot.Amazon.Service;

import com.SpringBoot.Amazon.Model.Orders;
import com.SpringBoot.Amazon.Repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository repository;

    public List<Orders> getOrders () {
        return repository.findAll();
    }

    public String postOrders (Orders orders) {
        repository.save(orders);
        return " Order SuccessFully Added .......! ";
    }

    public String putOrders(Orders orders) {
        repository.save(orders);
        return " Order SuccessFully Updated .......! ";
    }

    public String deleteOrders(long id) {
        repository.deleteById(id);
        return " Order Delete SuccessFully .......! ";
    }

    public String deleteListOfOrders(List<Long> orders) {
        for (Long id:orders) {
            repository.deleteById(id);
        }
        return " Orders Delete SuccessFully .......! ";
    }

    public List<Orders> queryOrders(Set<Long> id) {
        return repository.getId(id);
    }

}

