package com.tensquare.recruit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin            // 跨域
@RefreshScope           // 配置文件自动刷新
@RequestMapping("/ip")
public class TestConfigAutoLoadingController {

    @Value("${sms.ip}")
    private String ip;

    @RequestMapping(value = "/sms", method = RequestMethod.GET)
    public String ip() {
        return "sms.ip:" + ip;
    }
}
