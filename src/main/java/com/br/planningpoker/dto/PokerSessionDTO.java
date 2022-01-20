package com.br.planningpoker.dto;

public class PokerSessionDTO {

    private Long id;
    private String title;
    private DeckDTO deck;
    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DeckDTO getDeck() {
        return deck;
    }

    public void setDeck(DeckDTO deck) {
        this.deck = deck;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
