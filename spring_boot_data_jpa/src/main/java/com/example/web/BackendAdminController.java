package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xyfhy on 16/7/29.
 */
@Controller
public class BackendAdminController {

    @RequestMapping("/admin")
    public String backendAdmin(){
        return "index";
    }
}
