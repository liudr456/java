package com.cc.error;

public interface CommonError {
    int getErrorCode();
    String getErrorMsg();
    CommonError setErrorMsg(String errormsg);
}
