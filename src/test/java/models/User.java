package models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(exclude = "UUID")
public class User {
    private String email;
    private String password;
    private int UUID;
}
