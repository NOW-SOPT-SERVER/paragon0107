package org.example.DTO;

import java.util.Objects;
import org.example.Repogitory.UserRepository;

public record User(
        String name,
        String id,
        int password,
        Bank bank,
        Account account
) {
    public User(String name,String id,int password){
        this(name,id,password,null,null);
    }
    public static User create(String name,String id,int password){
        return new User(name,id,password);
    }

}
