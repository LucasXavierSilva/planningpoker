package com.br.planningpoker.facade.impl;

import com.br.planningpoker.converter.DeckConverter;
import com.br.planningpoker.converter.PokerSessionConverter;
import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.entity.Deck;
import com.br.planningpoker.entity.PokerSession;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.facade.PokerSessionFacade;
import com.br.planningpoker.service.DeckService;
import com.br.planningpoker.service.PokerSessionService;
import com.br.planningpoker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service("PokerSessionFacade")
@Lazy
public class PokerSessionFacadeImpl implements PokerSessionFacade {

    @Autowired
    PokerSessionService pokerSessionService;

    @Autowired
    DeckService deckService;

    @Autowired
    UserStoryService userStoryService;

    /**
     * Saves a new {@link  PokerSession}.
     *
     * @param pokerSessionDTO
     * @return
     */
    @Override
    public String savePokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException {
        if(pokerSessionDTO == null) {
            throw new PlanningPokerException("The Poker Session can not be null");
        }
        PokerSession pokerSession = getPokerSession(pokerSessionDTO);
        pokerSession = pokerSessionService.savePokerSession(pokerSession);
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/pokerSession/" + pokerSession.getId();
    }

    /**
     * Gets the {@link PokerSession} for saving.
     *
     * @param pokerSessionDTO
     * @return
     * @throws PlanningPokerException
     */
    private PokerSession getPokerSession(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException {
        Deck deck = getDeck(pokerSessionDTO);
        PokerSessionConverter pokerSessionConverter = new PokerSessionConverter();
        pokerSessionService.validatePokerSession(pokerSessionDTO);
        PokerSession pokerSession = pokerSessionConverter.pokerSessionDTOToPokerSession(pokerSessionDTO);
        pokerSession.setDeck(deck);
        return pokerSession;
    }

    /**
     * Gets the {@link Deck} for the {@link PokerSession}
     * @param pokerSessionDTO
     * @return
     * @throws PlanningPokerException
     */
    private Deck getDeck(PokerSessionDTO pokerSessionDTO) throws PlanningPokerException {
        deckService.validateDeck(pokerSessionDTO.getDeck());
        DeckConverter deckConverter = new DeckConverter();
        Deck deck = deckService.findDeckById(pokerSessionDTO.getDeck().getId());
        if(deck == null) {
            deck = deckConverter.deckDTOToDeck(pokerSessionDTO.getDeck());
            deckService.saveDeck(deck);
        }
        return deck;
    }
}
