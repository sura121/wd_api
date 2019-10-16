package com.weedoctor.api.repo;

import com.weedoctor.api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<Users, Integer> {


}
