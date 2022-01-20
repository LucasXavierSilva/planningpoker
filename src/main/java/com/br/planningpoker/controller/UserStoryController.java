package com.br.planningpoker.controller;

import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.dto.UserStoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserStoryController {
    ResponseEntity saveUserStory(@RequestBody UserStoryDTO userStoryDTO);

    ResponseEntity updateUserStory(@RequestBody UserStoryDTO userStoryDTO);

    ResponseEntity deleteUserStory(@PathVariable("id") Long id);

    ResponseEntity<UserStoryDTO> findUserStoryById(@PathVariable("id") Long id);
}
