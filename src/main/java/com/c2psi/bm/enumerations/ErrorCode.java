package com.c2psi.bm.enumerations;

public enum ErrorCode {
    USERBM_NOT_VALID(10),
    USERBM_DUPLICATED(11);
    private int errorCode;
    ErrorCode(int code){
        this.errorCode = code;
    }
    public int getErrorCode(){
        return errorCode;
    }


}
