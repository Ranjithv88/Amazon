package com.SpringBoot.Amazon.Service;

import com.SpringBoot.Amazon.Model.Address;
import com.SpringBoot.Amazon.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    public List<Address> getAddress () {
        return repository.findAll();
    }

    public String postAddress (Address address) {
        repository.save(address);
        return " Address SuccessFully Added .......! ";
    }

    public String putAddress(Address address) {
        repository.save(address);
        return " Address SuccessFully Updated .......! ";
    }

    public String deleteAddress(long id) {
        repository.deleteById(id);
        return " Address Delete SuccessFully .......! ";
    }

    public String deleteListOfAddress(List<Long> address) {
        for (Long id:address) {
            repository.deleteById(id);
        }
        return " Addresses Delete SuccessFully .......! ";
    }

    public List<Address> queryAddress(Set<Long> id) {
        return repository.getId(id);
    }

}

