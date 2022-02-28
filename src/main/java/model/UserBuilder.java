package model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserBuilder {
    private int id;
    private String login;
    private String password;

}
