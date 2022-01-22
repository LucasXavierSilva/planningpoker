package com.br.planningpoker.controller;

import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.dto.VoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface VoteController {
    ResponseEntity saveVote(@RequestBody VoteDTO voteDTO);
    ResponseEntity finishVote(@RequestBody UserStoryDTO userStory);

    ResponseEntity findUserById(@PathVariable("idUser") Long idUser, @PathVariable("idUserStory") Long idUserStory);
}
