package com.sweet.enums;

public enum ResultEnum {
    UNKNOWN_ERRO(-1,"未知错误"),
    SUCCESS(0,"操作成功"),
    FAIL(1,"操作失败"),
    RECORD_EMPTY(2,"未查询到记录"),
    ALLOW_YES(3,"允许"),
    ALLOW_NO(4,"未被允许")


    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
