package com.br.planningpoker.repository.impl;

import com.br.planningpoker.entity.Deck;
import com.br.planningpoker.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository("deckRepository")
@Lazy
@Transactional
public class DeckRepositoryImpl implements DeckRepository {

    @Autowired
    private EntityManager entityManager;

    /**
     * Saves the {@link Deck}.
     *
     * @param deck
     */
    @Override
    public void save(Deck deck) {
        entityManager.persist(deck);
        flushAndClear();
    }

    /**
     * Finds the {@link Deck} according to it's id.
     *
     * @param id
     * @return
     */
    @Override
    public Deck findById(Long id) {
        return entityManager.find(Deck.class, id);
    }

    /**
     * Flushes and Clear the {@link EntityManager}.
     */
    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
