package com.br.planningpoker.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_VOTE")
public class Vote {

    @EmbeddedId
    private VoteId voteId;

    @Column(name = "VALUE")
    private String value;

    public VoteId getVoteId() {
        return voteId;
    }

    public void setVoteId(VoteId voteId) {
        this.voteId = voteId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
