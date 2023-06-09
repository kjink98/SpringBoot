package com.jvision.admin.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    // 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성죈 사용자인지, 처음 가입하는 사용자인지 판단.

}
