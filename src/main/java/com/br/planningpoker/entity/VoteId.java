package com.br.planningpoker.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VoteId implements Serializable {

    private static final long serialVersionUID = -543343557458849557L;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "FK_USER")
    private User user;

    @ManyToOne(targetEntity = UserStory.class)
    @JoinColumn(name = "FK_USER_STORY")
    private UserStory userStory;

    public VoteId(User user, UserStory userStory) {
        this.user = user;
        this.userStory = userStory;
    }

    public VoteId() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }
}
