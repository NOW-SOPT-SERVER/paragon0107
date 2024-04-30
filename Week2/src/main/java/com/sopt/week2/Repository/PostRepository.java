package com.sopt.week2.Repository;

import com.sopt.week2.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
