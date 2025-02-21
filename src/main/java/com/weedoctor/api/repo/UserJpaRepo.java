package com.weedoctor.api.repo;

import com.weedoctor.api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yuequan.jpa.soft.delete.repository.SoftDelete;

import java.util.Optional;

@SoftDelete
public interface UserJpaRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUid(String email);

}
