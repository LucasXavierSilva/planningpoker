package com.br.planningpoker.exception;

public class PlanningPokerException extends Exception{

    public PlanningPokerException(String error) {
        super(error);
    }
    public PlanningPokerException(Exception error) {
        super(error);
    }

}
