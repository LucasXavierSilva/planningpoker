package com.br.planningpoker.dto;

import com.br.planningpoker.enums.EnumUserStoryStatus;

public class UserStoryDTO {

    private Long id;
    private String title;
    private String description;
    private String link;
    private EnumUserStoryStatus status;
    private PokerSessionDTO pokerSession;

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

    public PokerSessionDTO getPokerSession() {
        return pokerSession;
    }

    public void setPokerSession(PokerSessionDTO pokerSession) {
        this.pokerSession = pokerSession;
    }
}
