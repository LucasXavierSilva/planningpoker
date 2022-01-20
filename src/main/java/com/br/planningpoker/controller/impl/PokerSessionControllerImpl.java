package com.br.planningpoker.controller.impl;

import com.br.planningpoker.controller.PokerSessionController;
import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.facade.PokerSessionFacade;
import com.br.planningpoker.service.PokerSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PokerSessionControllerImpl implements PokerSessionController {
    private final static Logger logger = LoggerFactory.getLogger(PokerSessionControllerImpl.class);

    @Autowired
    private PokerSessionService pokerSessionService;

    @Autowired
    private PokerSessionFacade pokerSessionFacade;

    /**
     * Saves a new {@link  com.br.planningpoker.entity.PokerSession}.
     *
     * @param pokerSessionDTO
     */
    @RequestMapping(value = "/components/schemas/pokerSession", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseEntity<String> savePokerSession(@RequestBody PokerSessionDTO pokerSessionDTO) {
        try {
            return new ResponseEntity(pokerSessionFacade.savePokerSession(pokerSessionDTO), HttpStatus.CREATED);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates a {@link  com.br.planningpoker.entity.PokerSession}.
     *
     * @param pokerSessionDTO
     */
    @RequestMapping(value = "/components/schemas/pokerSession", method = RequestMethod.PUT)
    @ResponseBody
    @Override
    public ResponseEntity updatePokerSession(@RequestBody PokerSessionDTO pokerSessionDTO) {
        try {
            pokerSessionService.updatePokerSession(pokerSessionDTO);
            return new ResponseEntity(HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a {@link  com.br.planningpoker.entity.PokerSession} according to the it's id.
     *
     * @param idSession
     */
    @DeleteMapping(value = "/components/schemas/pokerSession/{idSession}")
    @Override
    public ResponseEntity deletePokerSession(@PathVariable("idSession") Long idSession) {
        try {
            pokerSessionService.deletePokerSession(idSession);
            return new ResponseEntity(HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finds a {@link  com.br.planningpoker.entity.PokerSession} according to the it's id.
     *
     * @param idSession
     */
    @GetMapping(value = "/components/schemas/pokerSession/{idSession}")
    @Override
    public ResponseEntity<PokerSessionDTO> findPokerSessionById(@PathVariable("idSession") Long idSession) {
        try {
            return new ResponseEntity(pokerSessionService.findPokerSessionDTOById(idSession), HttpStatus.OK);
        } catch (PlanningPokerException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
