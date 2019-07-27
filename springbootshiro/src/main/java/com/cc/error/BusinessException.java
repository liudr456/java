package com.cc.error;

public class BusinessException extends Exception implements CommonError {
    CommonError commonError;
    public BusinessException(CommonError commonError){
        super();
        this.commonError=commonError;
    }
    public BusinessException(CommonError commonError, String errorMsg){
        super();
        this.commonError=commonError;
        this.commonError.setErrorMsg(errorMsg);
    }
    @Override
    public int getErrorCode() {
        return commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errormsg) {
        this.commonError.setErrorMsg(errormsg);
        return this;
    }
}
