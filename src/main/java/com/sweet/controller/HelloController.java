package com.sweet.controller;

import com.sweet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.beans.factory.annotation.Value;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.RestController;*/

/**
 * Created by xc-sw on 2017/7/31.
 */
@Controller
@ResponseBody
//@RestController
public class HelloController {

    /*@Value("${age}")
    private Integer age;
    @Value("${sex}")
    private String sex;
    @Value("${statusEnable}")
    private Integer statusEnable;*/

    @Autowired
    private User user;

    //@RequestMapping(value = {"/hello","/hi"},method= RequestMethod.GET)
    @GetMapping(value={"/hello","/hi"})
    public String hello(){
        java.util.Random random=new java.util.Random();// 定义随机类
        int result=random.nextInt(10)+1;
        int flag = result%2;
        if(flag == user.getStatusEnable()){
            return user.getUserName()+"的年龄是："+user.getAge()+"<br/>他的性别为："+user.getSex();
        }
            return "用户已被禁用";
       // return  "index";

    }

    //@PostMapping(value = "/param")
    @GetMapping(value={"/param/{id}"})
    public String say(@PathVariable("id") Integer id){
        return "id为："+id;
    }

    @RequestMapping(value = "/param2",method = RequestMethod.GET)
    public String say2(@RequestParam("id") Integer myId){
        return "id为："+myId;
    }

    @RequestMapping(value = "/param3",method = RequestMethod.GET)
    public String say3(@RequestParam(value="id",required = false,defaultValue = "0") Integer myId){
        return "id为："+myId;
    }
}
