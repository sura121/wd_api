package com.weedoctor.api.controller.exception;

import com.weedoctor.api.advice.Exception.CAuthenticationEntryPointException;
import com.weedoctor.api.model.response.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @GetMapping(value = "/entrypoint")
    public CommonResult entrypointExcetpion() {
        throw new CAuthenticationEntryPointException();
    }
}
