package com.br.planningpoker.service;

import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.entity.UserStory;
import com.br.planningpoker.exception.PlanningPokerException;

public interface UserStoryService {
    UserStoryDTO saveUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException;

    void deleteUserStory(Long id) throws PlanningPokerException;

    UserStoryDTO updateUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException;

    UserStoryDTO findUserStoryDTOById(Long id) throws PlanningPokerException;

    UserStory findUserStoryById(Long id) throws PlanningPokerException;
}
