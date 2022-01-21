package com.br.planningpoker.controller;

import com.br.planningpoker.dto.PokerSessionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PokerSessionController {

    ResponseEntity<String> savePokerSession(PokerSessionDTO pokerSessionDTO);

    ResponseEntity updatePokerSession(@RequestBody PokerSessionDTO pokerSessionDTO);

    ResponseEntity deletePokerSession(@PathVariable("idSession") Long idSession);

    ResponseEntity<PokerSessionDTO> findPokerSessionById(@PathVariable("idSession") Long idSession);
}
