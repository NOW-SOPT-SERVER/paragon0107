package com.sopt.week2.Domain;

import com.sopt.week2.Domain.enums.Part;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;

    public static Member create(String name, Part part, int age) {
        Member member = new Member();
        member.name = name;
        member.part = part;
        member.age = age;
        return member;
    }
}