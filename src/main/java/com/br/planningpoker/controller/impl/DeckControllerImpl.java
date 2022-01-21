package com.br.planningpoker.controller.impl;

import com.br.planningpoker.controller.DeckController;
import com.br.planningpoker.dto.DeckDTO;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.service.DeckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeckControllerImpl implements DeckController {
    private static final Logger logger = LoggerFactory.getLogger(DeckControllerImpl.class);

    @Autowired
    private DeckService deckService;

    /**
     * Saves a new {@link  com.br.planningpoker.entity.Deck}.
     *
     * @param deckDTO
     */
    @PostMapping(value = "/components/schemas/deck")
    @ResponseBody
    @Override
    public ResponseEntity saveDeck(@RequestBody DeckDTO deckDTO) {
        try {
            deckService.saveDeck(deckDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finds a {@link  com.br.planningpoker.entity.Deck} according to the it's id.
     *
     * @param id
     */
    @GetMapping(value = "/components/schemas/deck/{id}")
    @Override
    public ResponseEntity<DeckDTO> findDeckById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(deckService.findDeckDTOById(id), HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
