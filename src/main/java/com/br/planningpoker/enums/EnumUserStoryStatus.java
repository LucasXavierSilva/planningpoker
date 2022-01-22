package com.br.planningpoker.enums;

public enum EnumUserStoryStatus {
    PENDING("PENDING"), VOTING("VOTING"), VOTED("VOTED");

    private static EnumUserStoryStatus[] userStoryStatuses = new EnumUserStoryStatus[]{PENDING, VOTING, VOTED};

    private String status;
    EnumUserStoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
