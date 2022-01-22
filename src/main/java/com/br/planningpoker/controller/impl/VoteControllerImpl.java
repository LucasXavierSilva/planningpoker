package com.br.planningpoker.controller.impl;


import com.br.planningpoker.controller.VoteController;
import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.dto.VoteDTO;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.facade.VoteFacade;
import com.br.planningpoker.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class VoteControllerImpl implements VoteController {
    private static  final Logger logger = LoggerFactory.getLogger(VoteControllerImpl.class);

    @Autowired
    VoteFacade voteFacade;

    @Autowired
    VoteService voteService;

    /**
     * Saves a new {@link  com.br.planningpoker.entity.Vote}.
     *
     * @param voteDTO
     */
    @PostMapping(value = "/components/schemas/vote")
    @ResponseBody
    @Override
    public ResponseEntity saveVote(@RequestBody VoteDTO voteDTO) {
        try {

            return new ResponseEntity<>(voteFacade.saveVote(voteDTO), HttpStatus.CREATED);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finishes a {@link  com.br.planningpoker.entity.Vote}.
     *
     * @param userStory
     * return
     */
    @PutMapping(value = "/components/schemas/finishVote")
    @ResponseBody
    @Override
    public ResponseEntity finishVote(@RequestBody UserStoryDTO userStory) {
        try {
            return new ResponseEntity<>(voteFacade.finishVote(userStory), HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finds a {@link  VoteDTO} according to the it's id.
     *
     * @param idUser
     * @param idUserStory
     * @return
     */
    @GetMapping(value = "/components/schemas/vote/{idUser}/{idUserStory}")
    @Override
    public ResponseEntity findUserById(@PathVariable("idUser") Long idUser, @PathVariable("idUserStory") Long idUserStory) {
        try {
            return new ResponseEntity<>(voteService.findVoteDTOById(idUser, idUserStory), HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
