package com.c2psi.bm.exceptions;

import com.c2psi.bm.enumerations.ErrorCode;

import java.util.List;

public class InvalidEntityException extends BMException{
    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCode errorCode, List<String> errors) {
        super(message, cause, errorCode, errors);
    }

    public InvalidEntityException(String message, ErrorCode errorCode, List<String> errors) {
        super(message, errorCode, errors);
    }

    public InvalidEntityException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
