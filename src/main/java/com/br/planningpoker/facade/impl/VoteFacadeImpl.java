package com.br.planningpoker.facade.impl;


import com.br.planningpoker.converter.UserStoryConverter;
import com.br.planningpoker.converter.VoteConverter;
import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.dto.VoteDTO;
import com.br.planningpoker.entity.User;
import com.br.planningpoker.entity.UserStory;
import com.br.planningpoker.entity.Vote;
import com.br.planningpoker.entity.VoteId;
import com.br.planningpoker.enums.EnumUserStoryStatus;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.facade.VoteFacade;
import com.br.planningpoker.service.UserService;
import com.br.planningpoker.service.UserStoryService;
import com.br.planningpoker.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("VoteFacade")
@Lazy
public class VoteFacadeImpl implements VoteFacade {

    @Autowired
    UserService userService;

    @Autowired
    UserStoryService userStoryService;

    @Autowired
    VoteService voteService;

    @Override
    public VoteDTO saveVote(VoteDTO voteDTO) throws PlanningPokerException {
        validadeVoteDTO(voteDTO);
        VoteConverter voteConverter = new VoteConverter();
        Vote vote = getVote(voteDTO, voteConverter);

        if(!StringUtils.hasLength(vote.getValue())) {
            vote.setValue("No Vote");
        }

        voteService.saveVote(vote);
        return voteConverter.voteToVoteDTO(vote);
    }

    /**
     * Finishes a voting sessions, updates the status for it's
     * correspondent {@link UserStory} and returns a list with the votes.
     *
     * @param userStoryDTO
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public List<VoteDTO> finishVote(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        if(userStoryDTO == null) {
            throw new PlanningPokerException("User story can not be null.");
        }
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        VoteConverter voteConverter = new VoteConverter();
        UserStory userStory = getUserStory(userStoryDTO);

        userStoryService.updateUserStory(userStoryConverter.userStoryToUserStoryDTO(userStory));

        return voteConverter.votesToVotesDTO(voteService.findVotesByUserStoryId(userStoryDTO.getId()));
    }

    private UserStory getUserStory(UserStoryDTO userStoryDTO) throws PlanningPokerException {
        UserStory userStory = userStoryService.findUserStoryById(userStoryDTO.getId());
        validateEndVotingSession(userStory);
        userStory.setStatus(EnumUserStoryStatus.VOTED);
        return userStory;
    }

    private void validateEndVotingSession(UserStory userStory) throws PlanningPokerException {
        if(EnumUserStoryStatus.VOTED.equals(userStory.getStatus())) {
            throw new PlanningPokerException("Voting session already voted.");
        }
        if(EnumUserStoryStatus.PENDING.equals(userStory.getStatus())) {
            throw new PlanningPokerException("Voting session hasn't started yet.");
        }
    }

    /**
     * Builds the {@link Vote} entity.
     *
     * @param voteDTO
     * @param voteConverter
     * @return
     * @throws PlanningPokerException
     */
    private Vote getVote(VoteDTO voteDTO, VoteConverter voteConverter) throws PlanningPokerException {
        Vote vote = voteConverter.voteDTOToVote(voteDTO);
        User user = userService.findUserById(voteDTO.getUser().getId());
        UserStory userStory = userStoryService.findUserStoryById(voteDTO.getUserStory().getId());
        validadeVote(user, userStory);

        VoteId voteId = new VoteId(user, userStory);
        vote.setVoteId(voteId);
        return vote;
    }

    /**
     * Validates the {@link Vote} before saving it.
     *
     * @param user
     * @param userStory
     * @throws PlanningPokerException
     */
    private void validadeVote(User user, UserStory userStory) throws PlanningPokerException {
        if(user == null) {
            throw new PlanningPokerException("User could not be found");
        }
        if(userStory == null) {
            throw new PlanningPokerException("User story could not be found");
        }
        if(EnumUserStoryStatus.VOTED.equals(userStory.getStatus())) {
            throw new PlanningPokerException("User story is already finished.");
        }
    }

    /**
     * Validates the {@link VoteDTO} for saving.
     *
     * @param voteDTO
     * @throws PlanningPokerException
     */
    private void validadeVoteDTO(VoteDTO voteDTO) throws PlanningPokerException {
        if(voteDTO == null) {
            throw new PlanningPokerException("Vote can not be null.");
        }
        if(voteDTO.getUser() == null) {
            throw new PlanningPokerException("User can not be null.");
        }
        if(voteDTO.getUserStory() == null) {
            throw new PlanningPokerException("User story can not be null.");
        }
    }
}
