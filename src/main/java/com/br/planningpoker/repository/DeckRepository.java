package com.br.planningpoker.repository;

import com.br.planningpoker.entity.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Long> {
}
