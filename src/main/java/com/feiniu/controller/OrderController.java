package com.feiniu.controller;

import com.feiniu.dto.OrderDto;
import com.feiniu.dto.ResponseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouqi on 2017/12/14.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping(value = "/createByJson")
    public ResponseDto createByJson(@RequestBody OrderDto orderDto){
        System.out.print(orderDto.toString());
        return new ResponseDto(0,"success");
    }

    @RequestMapping(value = "/createByUrlencoded")
    public ResponseDto createByUrlencoded(String orderNo,String appKey,String version){
        System.out.print("orderNo="+orderNo+",appKey="+appKey+",version="+version);
        return new ResponseDto(0,"success");
    }
}
