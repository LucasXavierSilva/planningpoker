package com.br.planningpoker.converter;

import com.br.planningpoker.dto.PokerSessionDTO;
import com.br.planningpoker.entity.PokerSession;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class PokerSessionConverter {

    /**
     * Converts {@link  PokerSessionDTO} to {@link PokerSession}.
     *
     * @param pokerSessionDTO
     * @return
     */
    public PokerSession pokerSessionDTOToPokerSession(PokerSessionDTO pokerSessionDTO) {
        if(pokerSessionDTO == null) {
            return null;
        }
        DeckConverter deckConverter = new DeckConverter();
        PokerSession pokerSession = new PokerSession();

        pokerSession.setId(pokerSessionDTO.getId());
        pokerSession.setTitle(pokerSessionDTO.getTitle());
        pokerSession.setDeck(deckConverter.deckDTOToDeck(pokerSessionDTO.getDeck()));

        return pokerSession;
    }

    /**
     * Converts {@link PokerSession} to {@link  PokerSessionDTO}.
     *
     * @param pokerSession
     * @return
     */
    public PokerSessionDTO pokerSessionToPokerSessionDTO(PokerSession pokerSession) {
        if(pokerSession == null) {
            return null;
        }
        DeckConverter deckConverter = new DeckConverter();
        PokerSessionDTO pokerSessionDTO = new PokerSessionDTO();

        pokerSessionDTO.setId(pokerSession.getId());
        pokerSessionDTO.setTitle(pokerSession.getTitle());
        pokerSessionDTO.setDeck(deckConverter.deckToDeckDTO(pokerSession.getDeck()));
        String link = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/pokerSession/" + pokerSession.getId();
        pokerSessionDTO.setLink(link);

        return pokerSessionDTO;
    }
}
