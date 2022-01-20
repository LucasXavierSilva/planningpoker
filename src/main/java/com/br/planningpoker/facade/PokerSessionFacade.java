package com.br.planningpoker.facade;

import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.exception.PlanningPokerException;

public interface PokerSessionFacade {
    String savePokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException;
}
