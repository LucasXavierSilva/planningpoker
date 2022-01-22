package com.br.planningpoker.service;

import com.br.planningpoker.dto.VoteDTO;
import com.br.planningpoker.entity.Vote;
import com.br.planningpoker.exception.PlanningPokerException;

import java.util.List;

public interface VoteService {
    void saveVote(Vote vote);

    VoteDTO findVoteDTOById(Long idUser, Long idUserStory) throws PlanningPokerException;

    List<Vote> findVotesByUserStoryId(Long userStoryId);

    List<Vote> findVotesByPokerSessionId(Long idSession);

    void deleteAll(List<Vote> votes);
}
