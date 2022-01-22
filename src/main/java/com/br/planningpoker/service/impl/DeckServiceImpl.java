package com.br.planningpoker.service.impl;

import com.br.planningpoker.converter.DeckConverter;
import com.br.planningpoker.dto.DeckDTO;
import com.br.planningpoker.entity.Deck;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.repository.DeckRepository;
import com.br.planningpoker.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@Transactional
public class DeckServiceImpl implements DeckService {

    @Autowired
    DeckRepository deckRepository;

    /**
     * Saves a new {@link  Deck} through a {@link DeckDTO}
     * Making the validations before saving.
     *
     * @param deckDTO
     * @return the
     */
    @Override
    public DeckDTO saveDeck(DeckDTO deckDTO) throws PlanningPokerException {
        validateDeck(deckDTO);
        DeckConverter deckConverter = new DeckConverter();
        Deck deck = deckConverter.deckDTOToDeck(deckDTO);
        return deckConverter.deckToDeckDTO(deckRepository.save(deck));
    }

    /**
     * Saves a new {@link  Deck}.
     *
     * @param deck
     * @return
     */
    @Override
    public Deck saveDeck(Deck deck) {
        deckRepository.save(deck);
        return deck;
    }

    /**
     * Find {@link DeckDTO} according to it's id.
     *
     * @param id
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public DeckDTO findDeckDTOById(Long id) throws PlanningPokerException {
        DeckConverter deckConverter = new DeckConverter();
        return deckConverter.deckToDeckDTO(findDeckById(id));
    }

    /**
     * Find {@link Deck} according to it's id.
     *
     * @param id
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public Deck findDeckById(Long id) throws PlanningPokerException {
        if(id == null) {
            return null;
        }
        Optional<Deck> deck = deckRepository.findById(id);

        if(!deck.isPresent()) {
            throw new PlanningPokerException("Deck could not be found");
        }
        return deck.get();
    }

    /**
     * Validates the {@link Deck}.
     *
     * @param deckDTO
     * @throws PlanningPokerException
     */
    @Override
    public void validateDeck(DeckDTO deckDTO) throws PlanningPokerException {
        if(deckDTO == null) {
            throw new PlanningPokerException("Deck is invalid.");
        }
        if(!StringUtils.hasLength(deckDTO.getType())) {
            throw new PlanningPokerException("Deck Type must not be empty");
        }
        if(CollectionUtils.isEmpty(deckDTO.getCards())) {
            throw new PlanningPokerException("Deck Cards must not be empty");
        }
    }
}
