package com.dto;

import com.validation.CustomerError;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote β Code is like humor. When you have to explain it, itβs bad.β β Cory House
 * @written_on 6/18/21 Friday
 */
public class Response {
    public boolean status;
    public CustomerError error;
    public String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CustomerError getError() {
        return error;
    }

    public void setError(CustomerError error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
