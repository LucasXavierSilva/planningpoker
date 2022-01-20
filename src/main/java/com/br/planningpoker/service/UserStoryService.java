package com.br.planningpoker.service;

import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.exception.PlanningPokerException;

public interface UserStoryService {
    void saveUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException;

    void deleteUserStory(Long id) throws PlanningPokerException;

    void updateUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException;

    UserStoryDTO findUserStoryDTOById(Long id) throws PlanningPokerException;
}
