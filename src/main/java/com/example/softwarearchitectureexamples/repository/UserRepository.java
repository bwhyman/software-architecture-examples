package com.example.softwarearchitectureexamples.repository;

import com.example.softwarearchitectureexamples.dox.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select * from user u join address a on u.id = a.user_id where a.id=:aid")
    User find(int aid);

    @Query("select * from user u where u.account=:account and u.password=:password")
    User find(String account, String password);
}
