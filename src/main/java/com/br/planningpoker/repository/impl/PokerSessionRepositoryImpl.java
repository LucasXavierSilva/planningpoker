package com.br.planningpoker.repository.impl;

import com.br.planningpoker.entity.PokerSession;
import com.br.planningpoker.repository.PokerSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository("pokerSessionRepository")
@Lazy
@Transactional
public class PokerSessionRepositoryImpl implements PokerSessionRepository {

    @Autowired
    private EntityManager entityManager;

    /**
     * Saves the {@link PokerSession}.
     *
     * @param pokerSession
     */
    @Override
    public void saveOrUpdate(PokerSession pokerSession) {
        if(pokerSession.getId() == null) {
            entityManager.persist(pokerSession);
        } else {
            entityManager.merge(pokerSession);
        }
    }

    /**
     * Finds the {@link PokerSession} according to it's id.
     *
     * @param idSession
     * @return
     */
    @Override
    public PokerSession findById(Long idSession) {
        return entityManager.find(PokerSession.class, idSession);
    }

    /**
     * Finds the {@link PokerSession} according to it's id.
     *
     * @param pokerSession
     * @return
     */
    @Override
    public void delete(PokerSession pokerSession) {
        entityManager.remove(pokerSession);
        flushAndClear();
    }

    /**
     * Flushes and Clear the {@link EntityManager}.
     */
    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

}
