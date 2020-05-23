package com.assessment.odwaassessment.exception;

public class KelvinToCelsiusException extends Exception {

    private String message;

    public KelvinToCelsiusException() {
    }

    public KelvinToCelsiusException(String message){
        this.message = message;
    }

}
