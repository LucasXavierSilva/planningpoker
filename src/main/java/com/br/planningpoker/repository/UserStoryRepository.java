package com.br.planningpoker.repository;

import com.br.planningpoker.entity.UserStory;
import org.springframework.data.repository.CrudRepository;

public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
}
