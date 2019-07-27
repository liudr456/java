package com.cc.error;
/**
 * 错误提示
 * */
public enum EnumBussinessError implements CommonError {
    UNKNOWN_ERROR(10001,"未知错误"),
    USER_NOT_EXIST(20001,"用户不存在"),
    USER_NOT_EMPTY(20002,"仍有用户使用此角色,无法删除");

    private int errorCode;
    private String errorMsg;
    EnumBussinessError(int errorCode,String errorMsg){
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public CommonError setErrorMsg(String errormsg) {
        this.errorMsg=errormsg;
        return this;
    }
}
