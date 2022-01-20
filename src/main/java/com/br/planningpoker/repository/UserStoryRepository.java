package com.br.planningpoker.repository;

import com.br.planningpoker.entity.UserStory;

public interface UserStoryRepository {
    void saveOrUpdate(UserStory userStory);

    UserStory findById(Long id);

    void delete(UserStory userStory);
}
