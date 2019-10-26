package com.weedoctor.api.controller.v1;

import com.weedoctor.api.advice.Exception.CEmailSigninFailedException;
import com.weedoctor.api.config.security.JwtTokenProvider;
import com.weedoctor.api.entity.Users;
import com.weedoctor.api.model.response.CommonResult;
import com.weedoctor.api.model.response.SingleResult;
import com.weedoctor.api.repo.UserJpaRepo;
import com.weedoctor.api.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
    @GetMapping(value = "/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,
                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {

        Users user = userJpaRepo.findByUid(id).orElseThrow(CEmailSigninFailedException::new);
        if(!passwordEncoder.matches(password, user.getPassword()))
            throw new CEmailSigninFailedException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @GetMapping(value = "/signup")
    public CommonResult sigin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,
                              @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
                              @ApiParam(value = "이름", required = true) @RequestParam String name) {

        userJpaRepo.save(Users.builder()
                .uid(id)
                .password(passwordEncoder.encode(password))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }



}
