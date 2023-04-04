package com.br.sopermutaapi.exception;

import lombok.Data;

@Data
public class ExceptionDetails {
    private int status;
    private String message;
    private String error;
}
