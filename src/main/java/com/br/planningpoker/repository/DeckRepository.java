package com.br.planningpoker.repository;

import com.br.planningpoker.entity.Deck;

public interface DeckRepository {
    void save(Deck deck);

    Deck findById(Long id);
}
