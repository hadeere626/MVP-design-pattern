package com.vodafone.mvpdesignpattern.bases;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class BaseError {

    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
