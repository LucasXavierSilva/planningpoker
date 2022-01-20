package com.br.planningpoker.repository.impl;

import com.br.planningpoker.entity.UserStory;
import com.br.planningpoker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository("userStoryRepository")
@Lazy
@Transactional
public class UserStoryRepositoryImpl implements UserStoryRepository {

    @Autowired
    private EntityManager entityManager;

    /**
     * Saves the {@link UserStory}.
     *
     * @param userStory
     */
    @Override
    public void saveOrUpdate(UserStory userStory) {
        if(userStory.getId() == null) {
            entityManager.persist(userStory);
        } else {
            entityManager.merge(userStory);
        }
    }

    /**
     * Finds the {@link UserStory} according to it's id.
     *
     * @param id
     * @return
     */
    @Override
    public UserStory findById(Long id) {
        return entityManager.find(UserStory.class, id);
    }

    /**
     * Deletes the {@link UserStory} according to it's id.
     *
     * @param userStory
     * @return
     */
    @Override
    public void delete(UserStory userStory) {
        entityManager.remove(userStory);
        flushAndClear();
    }

    /**
     * Flushes and Clear the {@link EntityManager}.
     */
    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
