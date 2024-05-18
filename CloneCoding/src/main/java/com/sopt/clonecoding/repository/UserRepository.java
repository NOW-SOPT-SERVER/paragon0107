package com.sopt.clonecoding.repository;



import com.sopt.clonecoding.domain.User;
import com.sopt.clonecoding.exception.CustomException;
import com.sopt.clonecoding.exception.ErrorCode;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    default User findUserById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)
                );
    }
}
