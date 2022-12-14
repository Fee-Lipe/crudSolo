package com.crud.primeirocrud.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {

    private static final Long serialVersionUID = 5894852616992131867L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
