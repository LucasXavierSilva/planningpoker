package com.br.planningpoker.repository;

import com.br.planningpoker.entity.PokerSession;

public interface PokerSessionRepository {

    void saveOrUpdate(PokerSession pokerSession);

    PokerSession findById(Long idSession);

    void delete(PokerSession pokerSession);
}
