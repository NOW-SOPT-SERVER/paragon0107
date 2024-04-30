package com.sopt.week2.Domain;


import com.sopt.week2.Service.Dto.BlogCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private  String description;


    private  Blog(Member member, String title, String description){
        this.member = member;
        this.title = title;
        this.description = description;
    }
    public static Blog create(Member member,BlogCreateRequest blogCreateRequest){
        return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
