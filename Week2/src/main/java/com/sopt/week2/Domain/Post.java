package com.sopt.week2.Domain;


import com.sopt.week2.Service.Dto.BlogCreateRequest;
import com.sopt.week2.Service.Dto.PostCreateRequest;
import jakarta.persistence.*;
import javax.swing.text.StringContent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post  extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;


    private  Post(Blog blog, String title, String content){
        this.title = title;
        this.content = content;
        this.blog = blog;
    }
    public static Post create(Blog blog, PostCreateRequest postCreateRequest){
        return new Post(blog, postCreateRequest.title(), postCreateRequest.content());
    }
}
