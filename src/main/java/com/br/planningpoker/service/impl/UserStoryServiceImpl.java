package com.br.planningpoker.service.impl;

import com.br.planningpoker.converter.UserStoryConverter;
import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.entity.UserStory;
import com.br.planningpoker.enums.EnumUserStoryStatus;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.repository.UserStoryRepository;
import com.br.planningpoker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserStoryServiceImpl implements UserStoryService {

    @Autowired
    UserStoryRepository userStoryRepository;

    /**
     * Saves a new {@link  UserStory}.
     *
     * @param userStoryDTO
     * @return
     */
    @Override
    public void saveUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        validateUserStory(userStoryDTO);
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        UserStory userStory = userStoryConverter.userStoryDTOToUserStory(userStoryDTO);
        userStoryRepository.saveOrUpdate(userStory);
    }

    /**
     * Deletes the {@link UserStory} according to it's id.
     *
     * @param id
     * @throws PlanningPokerException
     */
    @Override
    public void deleteUserStory(Long id) throws PlanningPokerException {
        UserStory userStory = findUserStoryById(id);
        if(userStory.getStatus().equals(EnumUserStoryStatus.VOTED)) {
            throw new PlanningPokerException("User Story with status VOTED can not be deleted.");
        }
        userStoryRepository.delete(userStory);
    }

    /**
     * Updates a {@link  com.br.planningpoker.entity.UserStory}.
     *
     * @param userStoryDTO
     */
    @Override
    public void updateUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        validateUserStory(userStoryDTO);
        findUserStoryById(userStoryDTO.getId());
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        UserStory userStory = userStoryConverter.userStoryDTOToUserStory(userStoryDTO);
        userStoryRepository.saveOrUpdate(userStory);
    }


    /**
     * Finds the {@link UserStoryDTO} according to it's id.
     *
     * @param id
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public UserStoryDTO findUserStoryDTOById(Long id) throws PlanningPokerException {
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        return userStoryConverter.userStoryToUserStoryDTO(findUserStoryById(id));
    }

    /**
     * Find {@link UserStory} according to it's id.
     *
     * @param id
     * @return
     * @throws PlanningPokerException
     */
    private UserStory findUserStoryById(Long id) throws PlanningPokerException {
        if(id == null) {
            return null;
        }
        UserStory userStory = userStoryRepository.findById(id);

        if(userStory == null) {
            throw new PlanningPokerException("User Story could not be found");
        }
        return userStory;
    }

    /**
     * Validates the {@link UserStory}.
     *
     * @param userStoryDTO
     * @throws PlanningPokerException
     */
    private void validateUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        if(userStoryDTO == null) {
            throw new PlanningPokerException("User Story is invalid.");
        }
        if(!StringUtils.hasLength(userStoryDTO.getTitle())) {
            throw new PlanningPokerException("User Story title must not be empty");
        }
    }
}