package com.br.planningpoker.entity;

import com.br.planningpoker.enums.EnumUserStoryStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_USER_STORY")
public class UserStory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER_STORY", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LINK")
    private String link;

    @Column(name = "STATUS")
    private EnumUserStoryStatus status;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="FK_POKER_SESSION")
    private PokerSession pokerSession;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public EnumUserStoryStatus getStatus() {
        return status;
    }

    public void setStatus(EnumUserStoryStatus status) {
        this.status = status;
    }

    public PokerSession getPokerSession() {
        return pokerSession;
    }

    public void setPokerSession(PokerSession pokerSession) {
        this.pokerSession = pokerSession;
    }
}
