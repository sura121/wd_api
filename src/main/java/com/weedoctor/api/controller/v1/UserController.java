package com.weedoctor.api.controller.v1;

import com.weedoctor.api.entity.Users;
import com.weedoctor.api.model.response.CommonResult;
import com.weedoctor.api.model.response.ListResult;
import com.weedoctor.api.model.response.SingleResult;
import com.weedoctor.api.repo.UserJpaRepo;
import com.weedoctor.api.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1")
public class UserController {

    private final UserJpaRepo userJpaRepo;
    private final ResponseService responseService;

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다.")
    @GetMapping(value = "/user")
    public ListResult<Users> findAllUser() {
        return responseService.getListResult(userJpaRepo.findAll());
    }

    @ApiOperation(value = "회원 추가", notes = "회원을 입력합니다.")
    @PostMapping(value = "/user")
    public SingleResult save(@ApiParam(value = "회원이름", required = true) @RequestParam String name,
                             @ApiParam(value = "회원 핸드폰 번호", required = true) @RequestParam String phoneNumber) {
        Users user = Users.builder()
                .phoneNumber(phoneNumber)
                .name(name)
                .build();

        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다")
    @PutMapping(value = "/user")
    public SingleResult<Users> modify(
            @ApiParam(value = "회원번호", required = true) @RequestParam int pk,
            @ApiParam(value = "회원아이디", required = false) @RequestParam String name,
            @ApiParam(value = "회원이름", required = false) @RequestParam String phoneNumber) {
        Users user = Users.builder()
                .pk(pk)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }


    @ApiOperation(value = "회원 삭제", notes = "pk값으로 회원을 삭제합니다.")
    @DeleteMapping(value = "/user/{pk}")
    public CommonResult delete(@ApiParam(value = "회원 번호", required = true) @RequestParam int pk){
        userJpaRepo.delete(userJpaRepo.getOne(pk));
        return responseService.getSuccessResult();
    }
}
