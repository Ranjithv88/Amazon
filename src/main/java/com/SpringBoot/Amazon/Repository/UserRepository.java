package com.SpringBoot.Amazon.Repository;

import com.SpringBoot.Amazon.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    String RawQuery = "SELECT * FROM user WHERE id IN :userid";
    @Query(nativeQuery = true,value = RawQuery)
    List<User> getId (@Param("userid") Set<Long> id);

}

