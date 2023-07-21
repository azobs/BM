package com.c2psi.bm.exceptions;

import com.c2psi.bm.enumerations.ErrorCode;

import java.util.List;

public class DuplicateEntityException extends BMException{
    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntityException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public DuplicateEntityException(String message, Throwable cause, ErrorCode errorCode, List<String> errors) {
        super(message, cause, errorCode, errors);
    }

    public DuplicateEntityException(String message, ErrorCode errorCode, List<String> errors) {
        super(message, errorCode, errors);
    }

    public DuplicateEntityException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
