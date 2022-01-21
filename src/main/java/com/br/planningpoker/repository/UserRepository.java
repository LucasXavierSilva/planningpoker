package com.br.planningpoker.repository;

import com.br.planningpoker.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
