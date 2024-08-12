package com.SpringBoot.Amazon.Service;

import com.SpringBoot.Amazon.Model.User;
import com.SpringBoot.Amazon.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUser () {
        return repository.findAll();
    }

    public String postUser (User user) {
        repository.save(user);
        return " User SuccessFully Register .......! ";
    }

    public String putUser (User user) {
        repository.save(user);
        return " User SuccessFully Updated .......! ";
    }

    public String deleteUser (long id) {
        repository.deleteById(id);
        return " User Delete SuccessFully .......! ";
    }

    public String deleteListOfUser (List<Long> user) {
        for (Long id:user) {
            repository.deleteById(id);
        }
        return " Users Delete SuccessFully .......! ";
    }

    public List<User> queryUser (Set<Long> id) {
        return repository.getId(id);
    }

}

