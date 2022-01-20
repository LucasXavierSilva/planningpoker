package com.br.planningpoker.controller;

import com.br.planningpoker.dto.DeckDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DeckController {
    ResponseEntity saveDeck(@RequestBody DeckDTO deckDTO);

    ResponseEntity<DeckDTO> findDeckById(@PathVariable("id") Long id);
}
