package com.weedoctor.api.service;

import com.weedoctor.api.advice.Exception.CUserNotFoundException;
import com.weedoctor.api.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    private final UserJpaRepo userJpaRepo;

    public UserDetails loadUserByUsername(String userPk) {
        return userJpaRepo.findByUid(userPk).orElseThrow(CUserNotFoundException::new);
    }

}
