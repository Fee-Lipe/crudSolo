package com.crud.primeirocrud.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7705854727538357796L;

    public DatabaseException(String msg){
        super(msg);
    }
}
