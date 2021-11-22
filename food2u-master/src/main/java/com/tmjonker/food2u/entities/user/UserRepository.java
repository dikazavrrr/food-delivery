package com.tmjonker.food2u.entities.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
