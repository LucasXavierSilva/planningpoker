package com.br.planningpoker.repository.impl;

import com.br.planningpoker.entity.User;
import com.br.planningpoker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository("userRepository")
@Lazy
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    /**
     * Saves the {@link User}.
     *
     * @param user
     */
    @Override
    public void save(User user) {
        entityManager.persist(user);
        flushAndClear();
    }

    /**
     * Finds the {@link User} according to it's id.
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Flushes and Clear the {@link EntityManager}.
     */
    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
