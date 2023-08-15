package pl.tomwodz.musicforum.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    public static User copyOf(User user){
        User result = new User();
        result.id = user.id;
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

    public User(Long id) {
        this.id = id;
    }

}

