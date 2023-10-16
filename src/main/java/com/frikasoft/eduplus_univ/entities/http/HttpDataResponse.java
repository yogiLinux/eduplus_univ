package com.frikasoft.eduplus_univ.entities.http;

public class HttpDataResponse<T> {

    private ErrorResponse error;
    private T response;

    public ErrorResponse getError() {

        return error;
    }

    public void setError(ErrorResponse error) {

        this.error = error;
    }

    public T getResponse() {

        return response;
    }

    public void setResponse(T response) {

        this.response = response;
    }
}
