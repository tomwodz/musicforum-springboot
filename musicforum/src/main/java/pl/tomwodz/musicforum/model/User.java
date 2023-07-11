package pl.tomwodz.musicforum.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private int idUser;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Role role;

    public static User copyOf(User user){
        User result = new User();
        result.idUser = user.idUser;
        result.login = user.login;
        result.password = user.password;
        result.name = user.name;
        result.surname = user.surname;
        result.email = user.email;
        result.role = user.role;
        return  result;
    }

    public enum Role{
        ADMIN,
        USER
    }

}

