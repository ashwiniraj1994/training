package com.moviesdb.exception;

public final class ExceptionMessages {


    private ExceptionMessages() {

    }
    //STATUS messages
    public static final String APP_OK = "OK";
    public static final String APP_ERROR = "ERROR";
    public static final String APP_WARN = "WARN";

    public static final String INVALID_PWD_ERROR = "Invalid Password";

    //Database related messages
    public static final String GENERIC_DATABASE_ERROR = "Database error occurred";
    public static final String GENERIC_NOT_FOUND = "Not found";
    public static final String DATABASE_CONNECTION_ERROR = "Error in connecting to database";
    public static final String DATABASE_CONSTRAINT_VOILATION_ERROR_ORDER = "Order with same ID already present";
    public static final String DATABASE_SQLGRAMMAR_ERROR = "Error in SQL syntax";
}
