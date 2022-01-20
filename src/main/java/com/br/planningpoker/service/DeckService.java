package com.br.planningpoker.service;

import com.br.planningpoker.dto.DeckDTO;
import com.br.planningpoker.entity.Deck;
import com.br.planningpoker.exception.PlanningPokerException;

public interface DeckService {
    void saveDeck(DeckDTO deckDTO) throws PlanningPokerException;

    Deck saveDeck(Deck deck);

    Deck findDeckById(Long id) throws PlanningPokerException;

    void validateDeck(DeckDTO deckDTO) throws PlanningPokerException;

    DeckDTO findDeckDTOById(Long id) throws PlanningPokerException;
}
