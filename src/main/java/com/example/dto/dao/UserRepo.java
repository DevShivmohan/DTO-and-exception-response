package com.example.dto.dao;

import com.example.dto.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {
    @Query(value = "select * from User",nativeQuery = true)
    public List<User> findAllUser();
}
