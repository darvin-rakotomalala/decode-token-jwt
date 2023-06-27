package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */
    ERR_USER_IPN_EMPTY("Error occurred - userIPN is null or empty"),
    ERR_USER_EXCEPTION("An exception occurred"),
    ERR_USER_TOKEN_NOT_FOUND("Error occurred - Null or empty bearer token");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
