package com.imooc.myo2o.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;

@Controller
@RequestMapping(value = "test")
public class TestController {
    @RequestMapping(value = "/host")
    @ResponseBody
    private String test(){
        String host = null;
        try{
            host = InetAddress.getLocalHost().getHostName();
            System.out.println("打印Host: "+host);
        }catch (Exception e){
            e.printStackTrace();
        }
        return host;
    }
}
