package com.sopt.week2.Repository;



import static com.sopt.week2.Common.Dto.ErrorMessage.MEMBER_NOT_FOUND;

import com.sopt.week2.Domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findMemberById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(MEMBER_NOT_FOUND.getMessage())
                );
    }
}