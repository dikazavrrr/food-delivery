package com.tmjonker.food2u.entities.restaurant;

import com.tmjonker.food2u.entities.user.User;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<User, Integer> {

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
