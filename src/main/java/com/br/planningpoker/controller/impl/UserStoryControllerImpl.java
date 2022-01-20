package com.br.planningpoker.controller.impl;

import com.br.planningpoker.controller.UserStoryController;
import com.br.planningpoker.dto.UserStoryDTO;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.service.UserStoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserStoryControllerImpl implements UserStoryController {
    private final static Logger logger = LoggerFactory.getLogger(UserStoryControllerImpl.class);

    @Autowired
    private UserStoryService userStoryService;

    /**
     * Saves a new {@link  com.br.planningpoker.entity.UserStory}.
     *
     * @param userStoryDTO
     */
    @RequestMapping(value = "/components/schemas/userStory", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseEntity saveUserStory(@RequestBody UserStoryDTO userStoryDTO) {
        try {
            userStoryService.saveUserStory(userStoryDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates a {@link  com.br.planningpoker.entity.UserStory}.
     *
     * @param userStoryDTO
     */
    @RequestMapping(value = "/components/schemas/userStory", method = RequestMethod.PUT)
    @ResponseBody
    @Override
    public ResponseEntity updateUserStory(@RequestBody UserStoryDTO userStoryDTO) {
        try {
            userStoryService.updateUserStory(userStoryDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a {@link  com.br.planningpoker.entity.UserStory} according to the it's id.
     *
     * @param id
     */
    @DeleteMapping(value = "/components/schemas/userStory/{id}")
    @Override
    public ResponseEntity deleteUserStory(@PathVariable("id") Long id) {
        try {
            userStoryService.deleteUserStory(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finds a {@link  com.br.planningpoker.entity.UserStory} according to the it's id.
     *
     * @param id
     */
    @GetMapping(value = "/components/schemas/userStory/{id}")
    @Override
    public ResponseEntity<UserStoryDTO> findUserStoryById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity(userStoryService.findUserStoryDTOById(id), HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
