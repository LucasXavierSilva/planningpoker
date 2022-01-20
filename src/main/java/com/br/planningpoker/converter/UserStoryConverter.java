package com.br.planningpoker.converter;

import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.entity.UserStory;

public class UserStoryConverter {

    /**
     * Converts {@link  UserStoryDTO} to {@link UserStory}.
     *
     * @param userStoryDTO
     * @return
     */
    public UserStory userStoryDTOToUserStory(UserStoryDTO userStoryDTO) {
        if(userStoryDTO == null) {
            return null;
        }
        UserStory userStory = new UserStory();
        PokerSessionConverter pokerSessionConverter = new PokerSessionConverter();

        userStory.setId(userStoryDTO.getId());
        userStory.setTitle(userStoryDTO.getTitle());
        userStory.setDescription(userStoryDTO.getDescription());
        userStory.setLink(userStoryDTO.getLink());
        userStory.setStatus(userStoryDTO.getStatus());
        userStory.setPokerSession(pokerSessionConverter.pokerSessionDTOToPokerSession(userStoryDTO.getPokerSession()));

        return userStory;
    }

    /**
     * Converts {@link  UserStory} to {@link UserStoryDTO}.
     *
     * @param userStory
     * @return
     */
    public UserStoryDTO userStoryToUserStoryDTO(UserStory userStory) {
        if(userStory == null) {
            return null;
        }
        UserStoryDTO userStoryDTO = new UserStoryDTO();
        PokerSessionConverter pokerSessionConverter = new PokerSessionConverter();

        userStoryDTO.setId(userStory.getId());
        userStoryDTO.setTitle(userStory.getTitle());
        userStoryDTO.setDescription(userStory.getDescription());
        userStoryDTO.setLink(userStory.getLink());
        userStoryDTO.setStatus(userStory.getStatus());
        userStoryDTO.setPokerSession(pokerSessionConverter.pokerSessionToPokerSessionDTO(userStory.getPokerSession()));

        return userStoryDTO;
    }
}
