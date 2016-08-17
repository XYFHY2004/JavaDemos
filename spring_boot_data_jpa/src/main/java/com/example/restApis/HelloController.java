package com.example.restApis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xyfhy on 16/7/28.
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Hello 徐, Welcome to Spring boot!";
    }
}
