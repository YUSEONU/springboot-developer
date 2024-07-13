package me.yuseonu.springbootdeveloper.repository;

import me.yuseonu.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// @Repository 를 사용하지 않아도 JpaRepository가 자동으로 등록해즘.
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // email로 사용자 정보를 가져옴
}
