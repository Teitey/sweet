package com.sweet.handle;

import com.sweet.enums.ResultEnum;
import com.sweet.exception.StudentException;
import com.sweet.result.Result;
import com.sweet.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一处理异常
 *
 * @author sweet
 * @create 2017-08-16 16:06
 **/
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if(e instanceof StudentException){
            StudentException se = (StudentException) e;
            return ResultUtil.fail(se.getCode(),se.getMessage());
        }else{
            logger.error("【系统未知异常】:{}",e);
            return ResultUtil.fail(ResultEnum.UNKNOWN_ERRO);
        } }

}
