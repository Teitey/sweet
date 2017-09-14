package com.sweet.exception;

import com.sweet.enums.ResultEnum;

/**
 * 自定义学生异常类
 *
 * @author sweet
 * @create 2017-08-16 16:21
 **/
public class StudentException extends RuntimeException{
    private Integer code;


    public StudentException(ResultEnum re) {
        super(re.getMsg());
        this.code = re.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
