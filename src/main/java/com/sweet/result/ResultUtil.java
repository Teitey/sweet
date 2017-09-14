package com.sweet.result;

import com.sweet.enums.ResultEnum;

/**
 * 返回结果工具类
 *
 * @author sweet
 * @create 2017-08-16 11:07
 **/
public class ResultUtil {
    private static  Integer SUCCESS_CODE = 1;
    private static  Integer FAIL_CODE = 0;

    private static  String SUCCESS_MSG= "操作成功";
    private static  String FAIL_MSG = "操作失败";

    /**
     * 返回成功，并带有结果
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result res = new Result();
        res.setCode(SUCCESS_CODE);
        res.setMsg(SUCCESS_MSG);
        res.setData(object);
        return  res;
    }

    /**
     * 返回成功，不带结果
     * @return
     */
    public static Result success(){
        return  success(null);
    }

    /**
     * 返回失败
     * @return
     */
    public static Result fail(){
        Result res = new Result();
        res.setCode(FAIL_CODE);
        res.setMsg(FAIL_MSG);
        return  res;
    }

    /**
     * 返回失败,自定义code和msg
     * @return
     */
    public static Result fail(Integer code,String msg){
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        return  res;
    }

    /**
     * 返回失败,自定义code和msg
     * @return
     */
    public static Result fail(ResultEnum re){
        Result res = new Result();
        res.setCode(re.getCode());
        res.setMsg(re.getMsg());
        return  res;
    }
}
