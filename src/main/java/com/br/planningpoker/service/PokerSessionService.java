package com.br.planningpoker.service;

import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.entity.PokerSession;
import com.br.planningpoker.exception.PlanningPokerException;

public interface PokerSessionService {

    PokerSession savePokerSession(PokerSession pokerSession);

    void updatePokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException;

    void deletePokerSession(Long idSession) throws PlanningPokerException;

    PokerSessionDTO findPokerSessionDTOById(Long idSession) throws PlanningPokerException;

    void validatePokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException;
}
