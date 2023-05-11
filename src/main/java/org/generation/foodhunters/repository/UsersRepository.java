package org.generation.foodhunters.repository;

import org.generation.foodhunters.repository.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <Users, Integer> {
}
