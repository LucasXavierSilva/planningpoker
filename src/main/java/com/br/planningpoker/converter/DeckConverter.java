package com.br.planningpoker.converter;

import com.br.planningpoker.dto.DeckDTO;
import com.br.planningpoker.entity.Deck;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DeckConverter {

    /**
     * Converts {@link  DeckDTO} to {@link Deck}.
     *
     * @param deckDTO
     * @return
     */
    public Deck deckDTOToDeck(DeckDTO deckDTO) {
        if(deckDTO == null) {
            return null;
        }
        Deck deck = new Deck();

        deck.setId(deckDTO.getId());
        deck.setType(deckDTO.getType());
        String cardsString = deckDTO.getCards() != null ? new Gson().toJson(deckDTO.getCards()) : null;
        deck.setCards(cardsString);

        return deck;
    }

    /**
     * Converts {@link  Deck} to {@link DeckDTO}.
     *
     * @param deck
     * @return
     */
    public DeckDTO deckToDeckDTO(Deck deck) {
        if(deck == null) {
            return null;
        }
        DeckDTO deckDTO = new DeckDTO();

        deckDTO.setId(deck.getId());
        deckDTO.setType(deck.getType());
        Type userListType = new TypeToken<ArrayList<String>>(){}.getType();
        List<String> cards = deck.getCards() != null ? new Gson().fromJson(deck.getCards(), userListType) : null;
        deckDTO.setCards(cards);

        return deckDTO;
    }
}
