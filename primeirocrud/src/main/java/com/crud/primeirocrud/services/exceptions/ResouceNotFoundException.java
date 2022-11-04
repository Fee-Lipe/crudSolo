package com.crud.primeirocrud.services.exceptions;

import java.io.Serial;

public class ResouceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 4060219103733665404L;

    public ResouceNotFoundException(String msg){
        super(msg);
    }
}
