package com.sopt.week2.Repository;

import com.sopt.week2.Domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
