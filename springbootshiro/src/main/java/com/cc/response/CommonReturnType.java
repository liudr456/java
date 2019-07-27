package com.cc.response;
/**
 * 统一返回值信息
 * */
public class CommonReturnType {
    private String status;
    private Object data;
    public static final String STATUS_FAIL="fail";
    public static final String STATUS_OK="success";


    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,STATUS_OK);
    }
    public static CommonReturnType create(Object result, String status){
        CommonReturnType commonReturnType=new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
