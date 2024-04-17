package com.sopt.week2.Repository;

import com.sopt.week2.Domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static com.sopt.week2.Execption.member.ErrorMessage.INVALID_MEMBER;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findMemberById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(INVALID_MEMBER.message)
                );
    }
}