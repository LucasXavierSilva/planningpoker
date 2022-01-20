package com.br.planningpoker.enums;

public enum EnumUserStoryStatus {
    PENDING("PENDING"),VOTED("VOTED");

    private static EnumUserStoryStatus[] enumUserStoryStatus = new EnumUserStoryStatus[]{PENDING, VOTED};

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

    public static EnumUserStoryStatus[] getEnumUserStoryStatus() {
        return enumUserStoryStatus;
    }

    public String toString() {
        return this.status;
    }

    public static void setEnumUserStoryStatus(EnumUserStoryStatus[] enumUserStoryStatus) {
        EnumUserStoryStatus.enumUserStoryStatus = enumUserStoryStatus;
    }
}
