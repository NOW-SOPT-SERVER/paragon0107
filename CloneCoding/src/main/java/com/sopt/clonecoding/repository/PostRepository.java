package com.sopt.clonecoding.repository;



import com.sopt.clonecoding.domain.Post;
import com.sopt.clonecoding.domain.User;
import com.sopt.clonecoding.exception.CustomException;
import com.sopt.clonecoding.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    default Post findPostById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.POST_NOT_FOUND)
                );
    }
}
