package com.br.planningpoker.repository;

import com.br.planningpoker.entity.Vote;
import com.br.planningpoker.entity.VoteId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, VoteId> {

    @Query(value = "SELECT v FROM Vote v WHERE v.voteId.userStory.id = ?1")
    List<Vote> findVotesByUserStoryId(Long userStoryId);

    @Query(value = "SELECT v FROM Vote v " +
            "   LEFT JOIN v.voteId.userStory us" +
            "   LEFT JOIN us.pokerSession ps WHERE ps.id = ?1")
    List<Vote> findVotesByPokerSessionId(Long idSession);
}
