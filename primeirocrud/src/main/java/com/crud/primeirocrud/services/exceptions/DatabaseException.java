package com.crud.primeirocrud.services.exceptions;


public class DatabaseException extends RuntimeException{

    private static final Long serialVersionUID = -7705854727538357796L;

    public DatabaseException(String msg){
        super(msg);
    }
}
