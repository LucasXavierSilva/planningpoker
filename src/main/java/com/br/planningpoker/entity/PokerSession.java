package com.br.planningpoker.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_POKER_SESSION")
public class PokerSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_POKER_SESSION")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @OneToOne()
    @JoinColumn(name="FK_DECK")
    private Deck deck;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "pokerSession", fetch = FetchType.LAZY)
    private List<UserStory> userStories;

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

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<UserStory> userStories) {
        this.userStories = userStories;
    }
}
