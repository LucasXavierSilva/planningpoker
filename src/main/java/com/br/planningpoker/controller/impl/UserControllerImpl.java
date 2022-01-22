package com.br.planningpoker.controller.impl;

import com.br.planningpoker.controller.UserController;
import com.br.planningpoker.dto.UserDTO;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllerImpl implements UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;

    /**
     * Saves a new {@link  com.br.planningpoker.entity.User}.
     *
     * @param userDTO
     */
    @PostMapping(value = "/components/schemas/user")
    @ResponseBody
    @Override
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        try {
            return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finds a {@link  com.br.planningpoker.entity.User} according to the it's id.
     *
     * @param id
     */
    @GetMapping(value = "/components/schemas/user/{id}")
    @Override
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(userService.findUserDTOById(id), HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
