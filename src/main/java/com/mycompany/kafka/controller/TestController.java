package com.mycompany.kafka.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class TestController extends BaseController{




    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Map initUserInfo() throws Exception {
        log.info("日志注解测试");
        logger.info("测试");
        return  new HashMap();
    }

}
