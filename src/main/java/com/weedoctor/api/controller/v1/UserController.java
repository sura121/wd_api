package com.weedoctor.api.controller.v1;

import com.weedoctor.api.entity.Users;
import com.weedoctor.api.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1")
public class UserController {

    private final UserJpaRepo userJpaRepo;

    @GetMapping(value = "user")
    public List<Users> findAllUser() {
        return userJpaRepo.findAll();
    }

    @PostMapping(value = "user")
    public Users save() {
        Users user = Users.builder()
                .phoneNumber("01012345678")
                .name("tester")
                .build();

        return userJpaRepo.save(user);
    }
}
