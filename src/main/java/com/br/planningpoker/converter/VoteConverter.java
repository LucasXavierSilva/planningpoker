package com.br.planningpoker.converter;

import com.br.planningpoker.dto.UserDTO;
import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.dto.VoteDTO;
import com.br.planningpoker.entity.User;
import com.br.planningpoker.entity.UserStory;
import com.br.planningpoker.entity.Vote;
import com.br.planningpoker.entity.VoteId;

import java.util.ArrayList;
import java.util.List;

public class VoteConverter {

    /**
     * Converts {@link  VoteDTO} to {@link Vote}.
     *
     * @param voteDTO
     * @return
     */
    public Vote voteDTOToVote(VoteDTO voteDTO) {
        if(voteDTO == null) {
            return null;
        }
        Vote vote = new Vote();
        vote.setVoteId(getVoteId(voteDTO));
        vote.setValue(voteDTO.getValue());
        return vote;
    }

    /**
     * Builds the {@link VoteId} according to the {@link UserStoryDTO}
     * and {@link UserDTO}.
     *
     * @param voteDTO
     * @return
     */
    private VoteId getVoteId(VoteDTO voteDTO) {
        UserConverter userConverter = new UserConverter();
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        User user = userConverter.userDTOToUser(voteDTO.getUser());
        UserStory userStory = userStoryConverter.userStoryDTOToUserStory(voteDTO.getUserStory());

        return new VoteId(user, userStory);
    }

    /**
     * Converts {@link  Vote} to {@link VoteDTO}.
     *
     * @param vote
     * @return
     */
    public VoteDTO voteToVoteDTO(Vote vote) {
        if(vote == null) {
            return null;
        }
        VoteDTO voteDTO = new VoteDTO();

        UserConverter userConverter = new UserConverter();
        UserStoryConverter userStoryConverter = new UserStoryConverter();
        UserDTO user = userConverter.userToUserDTO(vote.getVoteId().getUser());
        UserStoryDTO userStory = userStoryConverter.userStoryToUserStoryDTO(vote.getVoteId().getUserStory());

        voteDTO.setUser(user);
        voteDTO.setUserStory(userStory);
        voteDTO.setValue(vote.getValue());

        return voteDTO;
    }

    /**
     * Converts a list of {@link Vote} to a list of {@link VoteDTO}.
     *
     * @param votes
     * @return
     */
    public List<VoteDTO> votesToVotesDTO(List<Vote> votes) {
        if(votes == null) {
            return new ArrayList<>();
        }
        ArrayList<VoteDTO> votesDTO = new ArrayList<>();

        for (Vote vote : votes) {
            votesDTO.add(voteToVoteDTO(vote));
        }
        return votesDTO;
    }
}
