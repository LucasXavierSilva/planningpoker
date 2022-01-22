package com.br.planningpoker.dto;

public class VoteDTO {

    private UserDTO user;
    private UserStoryDTO userStory;
    private String value;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserStoryDTO getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStoryDTO userStory) {
        this.userStory = userStory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
