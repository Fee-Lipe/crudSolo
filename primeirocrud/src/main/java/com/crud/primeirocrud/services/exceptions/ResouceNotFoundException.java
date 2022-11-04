package com.crud.primeirocrud.services.exceptions;

public class ResouceNotFoundException extends RuntimeException{

    private static final Long serialVersionUID = 4060219103733665404L;

    public ResouceNotFoundException(String msg){
        super(msg);
    }
}
