package pl.tomwodz.musicforum.model;

import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Post {
    private int idPost;
    private int idUserAuthorOfPost;
    private String authorPost;
    private String contextPost;
    private ZonedDateTime dateCreation;
}
