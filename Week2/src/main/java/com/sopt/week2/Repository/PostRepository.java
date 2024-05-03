package com.sopt.week2.Repository;

import com.sopt.week2.Common.Dto.ErrorMessage;
import com.sopt.week2.Domain.Post;
import com.sopt.week2.Exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    default Post findPostById(Long id){
        return findById(id)
                .orElseThrow(
                        ()-> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
                );
    }
}
