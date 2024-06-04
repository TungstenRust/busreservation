package biz.simplebank.busreservation.models;

import org.springframework.http.HttpStatus;

public class ReservationApiException extends RuntimeException{
    private final HttpStatus status;
    private final String message;

//Custom Constructor
    public ReservationApiException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
//Getters

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

