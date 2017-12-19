package com.feiniu.controller;

import com.feiniu.dto.OrderDto;
import com.feiniu.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author zhouqi on 2017/12/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
    @Test
    public void createByJson() throws Exception {
        OrderDto orderDto=new OrderDto();
        orderDto.setOrderNo("testJson");
        orderDto.setAppKey("apt");
        orderDto.setVersion("1.0");
        Gson gson = new Gson();
        String json = gson.toJson(orderDto);
        String result = HttpUtil.postByJson("http://localhost:8080/order/createByJson",json);
        System.out.println(result);
    }

    @Test
    public void createByUrlencoded() throws Exception{
        Map<String,String> param = new HashMap<>();
        param.put("orderNo","testMap");
        param.put("appKey","apt");
        param.put("version","2.0");
        String result = HttpUtil.postByMap("http://localhost:8080/order/createByUrlencoded",param);
        System.out.println(result);
    }

}