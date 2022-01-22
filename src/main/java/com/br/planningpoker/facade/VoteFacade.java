package com.br.planningpoker.facade;

import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.dto.VoteDTO;
import com.br.planningpoker.exception.PlanningPokerException;

import java.util.List;

public interface VoteFacade {
    VoteDTO saveVote(VoteDTO voteDTO) throws PlanningPokerException;

    List<VoteDTO> finishVote(UserStoryDTO userStoryId) throws PlanningPokerException;
}
