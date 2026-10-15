package me.jmlee.springdeveloper.repository;

import me.jmlee.springdeveloper.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}