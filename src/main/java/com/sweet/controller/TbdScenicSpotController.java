package com.sweet.controller;

import com.sweet.domain.TbdScenicSpot;
import com.sweet.enums.ResultEnum;
import com.sweet.repository.TbdScenicSpotRepository;
import com.sweet.result.Result;
import com.sweet.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: Sweet
 *
 * @Description: 景区控制类
 *
 * @Date: 10:49 2017/8/21
 */
@RestController
public class TbdScenicSpotController {

    @Autowired
    private TbdScenicSpotRepository tbdScenicSpotRepository;

    @GetMapping(value = "/scenic/list")
    public Result queryScenicSpotList(){
        List<TbdScenicSpot> list = tbdScenicSpotRepository.findAll();
        if(list==null || list.size() == 0 ){
            return ResultUtil.fail(ResultEnum.RECORD_EMPTY);
        }
        return ResultUtil.success(list);
    }

}
