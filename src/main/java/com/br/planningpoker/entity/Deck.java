package com.br.planningpoker.entity;


import javax.persistence.*;

@Entity
@Table(name = "TB_DECK")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DECK", nullable = false)
    private Long id;

    @Column(name = "DECK_TYPE")
    private String type;

    @Column(name = "DECK_CARDS")
    private String cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }
}
