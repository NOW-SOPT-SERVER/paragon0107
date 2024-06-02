package org.sopt.spring.repository;

import java.util.Optional;

import org.sopt.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByName(String name) ;
}
