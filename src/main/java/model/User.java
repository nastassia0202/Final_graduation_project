package model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User {
    private int id;
    private String login;
    private String password;

    public User getUser(){
        return User.builder()
                .login("database")
                .password("database")
                .build();
    }
}
