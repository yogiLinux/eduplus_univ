package com.frikasoft.eduplus_univ.settings;

public class DataValueException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = -3943823518036074476L;

    public DataValueException() {
    }

    public DataValueException(String message) {

        super(message);
    }

    public DataValueException(Throwable cause, String message) {

        super(message, cause);
    }
}
