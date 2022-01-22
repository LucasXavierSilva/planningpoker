package com.br.planningpoker.service.impl;

import com.br.planningpoker.converter.VoteConverter;
import com.br.planningpoker.dto.VoteDTO;
import com.br.planningpoker.entity.User;
import com.br.planningpoker.entity.UserStory;
import com.br.planningpoker.entity.Vote;
import com.br.planningpoker.entity.VoteId;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.repository.VoteRepository;
import com.br.planningpoker.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;

    /**
     * Saves a new {@link Vote}.
     *
     * @param vote; entity to be saved
     */
    @Override
    public void saveVote(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public VoteDTO findVoteDTOById(Long idUser, Long idUserStory) throws PlanningPokerException {
        User user = new User();
        user.setId(idUser);
        UserStory userStory = new UserStory();
        userStory.setId(idUserStory);

        VoteConverter voteConverter = new VoteConverter();

        Optional<Vote> vote = voteRepository.findById(new VoteId(user,userStory));
        if(!vote.isPresent()) {
            throw new PlanningPokerException("Vote could not be found");
        }

        return voteConverter.voteToVoteDTO(vote.get());
    }

    /**
     * Finds a list of {@link Vote} according to the id of a
     * {@link UserStory}.
     *
     * @param userStoryId id of the {@link UserStory}
     * @return votes <-- list of votes
     */
    @Override
    public List<Vote> findVotesByUserStoryId(Long userStoryId) {
        return voteRepository.findVotesByUserStoryId(userStoryId);
    }

    /**
     * Finds a list of {@link Vote} related to the {@link com.br.planningpoker.entity.PokerSession}
     * @param idSession
     * @return
     */
    @Override
    public List<Vote> findVotesByPokerSessionId(Long idSession) {
        return voteRepository.findVotesByPokerSessionId(idSession);
    }

    @Override
    public void deleteAll(List<Vote> votes) {
        voteRepository.deleteAll(votes);
    }
}
