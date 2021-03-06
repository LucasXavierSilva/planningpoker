package com.br.planningpoker.service.impl;

import com.br.planningpoker.converter.PokerSessionConverter;
import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.entity.PokerSession;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.repository.PokerSessionRepository;
import com.br.planningpoker.service.PokerSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@Transactional
public class PokerSessionServiceImpl implements PokerSessionService {

    @Autowired
    PokerSessionRepository pokerSessionRepository;

    /**
     * Saves a new {@link  PokerSession}.
     *
     * @param pokerSession
     * @return
     */
    @Override
    public PokerSession savePokerSession(PokerSession pokerSession) {
        pokerSessionRepository.save(pokerSession);
        return pokerSession;
    }

    /**
     * Updates a {@link PokerSession}.
     *
     * @param pokerSessionDTO
     * @return
     */
    @Override
    public PokerSessionDTO updatePokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException {
        validatePokerSession(pokerSessionDTO);
        PokerSessionConverter pokerSessionConverter = new PokerSessionConverter();
        findPokerSessionById(pokerSessionDTO.getId());
        PokerSession pokerSession = pokerSessionConverter.pokerSessionDTOToPokerSession(pokerSessionDTO);
        return pokerSessionConverter.pokerSessionToPokerSessionDTO(pokerSessionRepository.save(pokerSession));
    }

    /**
     * Deletes the {@link PokerSession} according to it's id.
     *
     * @param idSession
     * @throws PlanningPokerException
     */
    @Override
    public void deletePokerSession(Long idSession) throws PlanningPokerException {
        if(idSession == null) {
            throw new PlanningPokerException("The Session id can not be null.");
        }
        pokerSessionRepository.delete(findPokerSessionById(idSession));

    }

    /**
     * Finds the {@link PokerSessionDTO} according to it's id.
     *
     * @param idSession
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public PokerSessionDTO findPokerSessionDTOById(Long idSession) throws PlanningPokerException {
        PokerSessionConverter pokerSessionConverter = new PokerSessionConverter();
        return pokerSessionConverter.pokerSessionToPokerSessionDTO(findPokerSessionById(idSession));
    }

    /**
     * Find {@link PokerSession} according to it's id.
     *
     * @param idSession
     * @return
     */
    public PokerSession findPokerSessionById(Long idSession) throws PlanningPokerException {
        if(idSession == null) {
            return null;
        }
        Optional<PokerSession> pokerSession = pokerSessionRepository.findById(idSession);

        if(!pokerSession.isPresent()) {
            throw new PlanningPokerException("Session could not be found");
        }
        return pokerSession.get();
    }

    /**
     * Validates a created {@link PokerSession} verifying if its fields are properly created.
     *
     * @param pokerSessionDTO
     * @throws PlanningPokerException
     */
    @Override
    public void validatePokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException {
        if(pokerSessionDTO == null) {
            throw new PlanningPokerException("Poker session can not be null.");
        }
        if(!StringUtils.hasLength(pokerSessionDTO.getTitle())) {
            throw new PlanningPokerException("The Title can not be neither null nor empty.");
        }
        if(pokerSessionDTO.getDeck() == null) {
            throw new PlanningPokerException("A deck must be selected.");
        }
    }
}
