package com.example.CRUD.repository;

import com.example.CRUD.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

/*
*ejemplo de abajo con @Querry es para crea una peticion usando querrys personalidados sql
* y el Optional de abajo hace lo mismo pero usando un mentodo
 */
    //@Querry("SELECT * FROM Users p WHERE p.name= ?1")

Optional<User> findUserByName(String name );




}
