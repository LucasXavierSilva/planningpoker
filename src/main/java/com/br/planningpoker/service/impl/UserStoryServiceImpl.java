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

import java.util.Optional;

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
    public UserStoryDTO saveUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        validateUserStory(userStoryDTO);
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        userStoryDTO.setStatus(EnumUserStoryStatus.PENDING);
        UserStory userStory = userStoryConverter.userStoryDTOToUserStory(userStoryDTO);
        return userStoryConverter.userStoryToUserStoryDTO(userStoryRepository.save(userStory));
    }

    /**
     * Deletes the {@link UserStory} according to it's id.
     *
     * @param id
     * @throws PlanningPokerException
     */
    @Override
    public void deleteUserStory(Long id) throws PlanningPokerException {
        if(id == null) {
            throw new PlanningPokerException("The User Story id can not be null.");
        }
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
     * @return
     */
    @Override
    public UserStoryDTO updateUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        validateUserStory(userStoryDTO);
        findUserStoryById(userStoryDTO.getId());
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        UserStory userStory = userStoryConverter.userStoryDTOToUserStory(userStoryDTO);
        return userStoryConverter.userStoryToUserStoryDTO(userStoryRepository.save(userStory));
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
    @Override
    public UserStory findUserStoryById(Long id) throws PlanningPokerException {
        if(id == null) {
            throw new PlanningPokerException("The User Story id can not be null.");
        }
        Optional<UserStory> userStory = userStoryRepository.findById(id);

        if(!userStory.isPresent()) {
            throw new PlanningPokerException("User Story could not be found");
        }
        return userStory.get();
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
