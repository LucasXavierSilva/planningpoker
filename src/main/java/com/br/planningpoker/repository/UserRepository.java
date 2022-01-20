package com.br.planningpoker.repository;

import com.br.planningpoker.entity.User;

public interface UserRepository {
    void save(User user);

    User findById(Long id);
}
