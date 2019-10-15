package com.weedoctor.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping(value = "/test/hello")
    @ResponseBody
    public String testString() {
        return "test";
    }
}
