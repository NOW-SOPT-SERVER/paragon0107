package org.sopt.spring.member.repository;

import java.util.Optional;
import org.sopt.spring.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name) ;
}
